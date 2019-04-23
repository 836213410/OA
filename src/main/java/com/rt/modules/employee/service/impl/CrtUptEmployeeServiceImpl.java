package com.rt.modules.employee.service.impl;



import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rt.global.constant.ResConstant;
import com.rt.global.dto.BaseRes;
import com.rt.modules.employee.dto.req.CrtUptEmployeeReq;
import com.rt.modules.employee.mapper.EmployeeMapper;
import com.rt.modules.employee.po.EmployeePo;
import com.rt.modules.employee.service.CrtUptEmployeeService;

/** 
 * Description: 修改[employee]管理接口实现类 <br/>
 * Generate by Wanpeng.Hui's Pengpeng-Generator 2019/04/23 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
@Service
public class CrtUptEmployeeServiceImpl implements CrtUptEmployeeService{
	
	@Autowired
	private EmployeeMapper employeeMapper; // Mapper
	
	private static Logger logger = LoggerFactory.getLogger(CrtUptEmployeeServiceImpl.class); // 记录日志
   
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public BaseRes crtEmployee(CrtUptEmployeeReq req) {
		return crtUptEmployee(req, true); // 执行添加
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public BaseRes uptEmployee(CrtUptEmployeeReq req) {
		return crtUptEmployee(req, false); // 执行修改
	}
    
    /**
	 * Description: 执行添加或修改<br/>
	 * Create info: Wanpeng.Hui, 2019/04/23  <br/>
	 *
	 * @param req
	 * @param isCreate
	 * @return
	 */
    private BaseRes crtUptEmployee(CrtUptEmployeeReq req, boolean isCreate){
        BaseRes res = new BaseRes();

        checkPara(req, res, isCreate); // 检查参数
		if (ResConstant.OPR_FAIL_PARAMETER.equals(res.getResCode())) {
			return res;
		}

		EmployeePo employeePo = null;
 		if (isCreate) {
 		    // 创建PO对象并组装参数
 			employeePo = new EmployeePo();
			//employeePo.setId(genIdFcService.genIdn(0));  // 员工id
 		} else {
 		    // 根据主键从数据库查找对象
 			employeePo = employeeMapper.findObjByPk(req.getId());
 			
 			// 如果未能查到对象, 运回错误信息
 			if (employeePo == null) {
 				res.setResCode(ResConstant.OPR_FAIL);
 				res.setResMsg("根据主键" + req.getId() + "找不到对象");
 				logger.error("根据主键{}找不到对象", req.getId());
 				return res;
 			}
 		}
		
 		employeePo.setUsername(req.getUsername()); // 用户名
 		employeePo.setRealname(req.getRealname()); // 真实姓名
 		employeePo.setEmail(req.getEmail()); // 电子邮件
 		employeePo.setMobile(req.getMobile()); 
 		employeePo.setAge(req.getAge()); // 年龄
 		employeePo.setSex(req.getSex()); // 性别 1为男0为女
 		employeePo.setHiredate(req.getHiredate()); // 入职时间
 		employeePo.setDeparturetime(req.getDeparturetime()); // 离职时间
 		employeePo.setStatus(req.getStatus()); // 在职状态，默认1在职，0离职
 		employeePo.setDepartmentId(req.getDepartmentId()); // 所属部门
 		employeePo.setEmployeeId(req.getEmployeeId()); // 直属领导
 		employeePo.setRmk(req.getRmk()); // 备注
 		employeePo.setJobnumber(req.getJobnumber()); // 工号
 		employeePo.setSalaryId(req.getSalaryId()); 
 		employeePo.setEdubg(req.getEdubg()); // 学历 1本科2大专3硕士4博士5大专以下
 		employeePo.setDltFlg(req.getDltFlg()); // 删除类型
 		employeePo.setIdcard(req.getIdcard()); // 身份证号码
		
		if(isCreate){
		    employeeMapper.insert(employeePo); // 执行插入
 			logger.info("添加成功, 返回主键: {}", employeePo.getId()); // 跟踪日志
		}
		else{
		    employeeMapper.updateByPk(employeePo); // 执行修改
 			logger.info("修改数据");
		}
    
         // 设置响应结果码
         res.setResCode(ResConstant.OPR_SUCC);
    	 res.setResMsg("执行修改操作成功");
		 return res;
    }
    
    /**
	 * Description: 检查参数 <br/>
	 * Create info: Wanpeng.Hui, 2019/04/23  <br/>
	 *
	 * @return
	 */
	private void checkPara(CrtUptEmployeeReq req, BaseRes res, boolean isCreate) {

		// 检查参数-主键, 修改时不能为空
        if(!isCreate && null == req.getId()){
            res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("员工id必填");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-用户名不能为空
        if(StringUtils.isEmpty(req.getUsername())){
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("用户名必填");
			logger.warn(res.getResMsg());
			return;
		}
	    // 检查参数-用户名长度限制
	    if(req.getUsername().length()>9){
	        res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("用户名参数太长");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-真实姓名不能为空
        if(StringUtils.isEmpty(req.getRealname())){
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("真实姓名必填");
			logger.warn(res.getResMsg());
			return;
		}
	    // 检查参数-真实姓名长度限制
	    if(req.getRealname().length()>9){
	        res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("真实姓名参数太长");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-电子邮件不能为空
        if(StringUtils.isEmpty(req.getEmail())){
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("电子邮件必填");
			logger.warn(res.getResMsg());
			return;
		}
	    // 检查参数-电子邮件长度限制
	    if(req.getEmail().length()>9){
	        res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("电子邮件参数太长");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-mobile不能为空
        if(StringUtils.isEmpty(req.getMobile())){
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("mobile必填");
			logger.warn(res.getResMsg());
			return;
		}
	    // 检查参数-mobile长度限制
	    if(req.getMobile().length()>5){
	        res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("mobile参数太长");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-年龄不能为空
		if(null == req.getAge()){
            res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("年龄必填");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-所属部门不能为空
		if(null == req.getDepartmentId()){
            res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("所属部门必填");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-直属领导不能为空
		if(null == req.getEmployeeId()){
            res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("直属领导必填");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-salaryId不能为空
		if(null == req.getSalaryId()){
            res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("salaryId必填");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-身份证号码不能为空
        if(StringUtils.isEmpty(req.getIdcard())){
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("身份证号码必填");
			logger.warn(res.getResMsg());
			return;
		}
	    // 检查参数-身份证号码长度限制
	    if(req.getIdcard().length()>7){
	        res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("身份证号码参数太长");
			logger.warn(res.getResMsg());
			return;
		}
	}
}
