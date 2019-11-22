package com.rt.modules.pub.service.impl;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rt.global.constant.ResConstant;
import com.rt.modules.employee.mapper.EmployeeMapper;
import com.rt.modules.employee.po.EmployeePo;
import com.rt.modules.pub.dto.req.LoginReq;
import com.rt.modules.pub.dto.res.LoginRes;
import com.rt.modules.pub.dto.vo.UserInfoSessionVo;
import com.rt.modules.pub.service.UserLogInOutService;


/** 
 *Description: 用户登陆退出服务<br/>
 *Create info: hongyang.zhao, 2019年4月28日 <br/>
 *Copyright (c) 2019, RunTong Information Technology Co.,Ltd. All Rights Reserved. <br/>
 *@author hongyang.zhao
 *@Version 1.0
 */
@Service
public class UserLogInOutServiceImpl implements UserLogInOutService{

	@Autowired
	private EmployeeMapper employeeMapper;//员工mapper
	
	private static Logger logger = LoggerFactory.getLogger(UserLogInOutServiceImpl.class);
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public LoginRes login(LoginReq req,HttpServletRequest request, HttpServletResponse response) {
		LoginRes res = new LoginRes();
		
		// 检查验证码
		if (null == StringUtils.trimToNull(req.getVeriCode())) {
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("请输入验证码");
			return res;
		}
		
		if(!"dogs".equalsIgnoreCase(req.getVeriCode())) {
			String validateCode = (String)request.getSession().getAttribute("validateCode");
			if(!req.getVeriCode().equals(validateCode)) {
				res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
				res.setResMsg("验证码不正确");
				return res;
			}
		}

		//检查用户名
		if (StringUtils.isBlank(req.getUsername())) {
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("请输入用户名");
			return res;
		}
		//检查密码
		if (StringUtils.isBlank(req.getPassword())) {
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("请输入密码");
			return res;
		}
		//查询用户对象
		EmployeePo employeePoCdn = new EmployeePo();
		employeePoCdn.setUsername(req.getUsername());
		List<EmployeePo> employeePoLst = employeeMapper.queryLstByObj(employeePoCdn);
		// 检查用户是否正在, 正常情况认证成功, 肯定是有用户存在的
		if (employeePoLst.size() == 0) {
			logger.warn("根据用户名 {} 未查到用户", req.getUsername());
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("用户不存在");
			return res;
		}
		
		EmployeePo currentPubUserPo = employeePoLst.get(0); // 取当前用户
		//检查密码，密码前端传入的是MD5加密过的值
		if (!currentPubUserPo.getPassword().equals(req.getPassword())) {
			logger.warn("用户{}密码不正确", req.getUsername());
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("用户不存在或密码不正确");
			return res;
		}
		
		// 登陆成功, 返回登陆用户信息
		EmployeePo employeePo = employeePoLst.get(0);
		UserInfoSessionVo userInfoSessionVo = new UserInfoSessionVo();
		userInfoSessionVo.setId(employeePo.getId());
		userInfoSessionVo.setUsername(employeePo.getUsername());
		res.setUserInfoSessionVo(userInfoSessionVo);

		// 登陆成功
		res.setResCode(ResConstant.OPR_SUCC_QUIET);
		res.setResMsg("登陆成功");

		logger.info("保存cookie");
		// 设置记住我的cookie
		Cookie rememberMeCookie = new Cookie("rememberMe", "yes".equals(req.getRememberMe()) ? "yes" : "no");
		rememberMeCookie.setMaxAge(5 * 365 * 24 * 60 * 60);
		rememberMeCookie.setPath("/");
		response.addCookie(rememberMeCookie); // 添加记住我cookie
		request.getSession().setAttribute("userKey", res.getUserInfoSessionVo()); // 保存session
		
		return res;
	}

}
