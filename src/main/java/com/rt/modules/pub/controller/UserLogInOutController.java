package com.rt.modules.pub.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rt.global.controller.BaseController;
import com.rt.global.dto.BaseRes;
import com.rt.modules.pub.dto.req.LoginReq;
import com.rt.modules.pub.service.UserLogInOutService;



/** 
 *Description: 用户登录控制器<br/>
 *Create info: hongyang.zhao, 2019年4月28日 <br/>
 *Copyright (c) 2019, RunTong Information Technology Co.,Ltd. All Rights Reserved. <br/>
 *@author hongyang.zhao
 *@Version 1.0
 */
@Controller
@RequestMapping("/pub")
public class UserLogInOutController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(UserLogInOutController.class);

	
	@Autowired
  	private UserLogInOutService userLogInOutService;
	
	
	@RequestMapping(value = "/userlogin")
	public @ResponseBody BaseRes userlogin(LoginReq req, HttpServletRequest request, HttpServletResponse response) {
		logger.info("进入登录控制器, 用户名:{}, 密码:{}, 验证码{}", req.getUsername(), req.getPassword(), req.getVeriCode());
		BaseRes res = userLogInOutService.login(req, request, response);
	
     	return res;

	}
}
