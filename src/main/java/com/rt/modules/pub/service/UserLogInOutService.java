package com.rt.modules.pub.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rt.modules.pub.dto.req.LoginReq;
import com.rt.modules.pub.dto.res.LoginRes;

/** 
 *Description: 用户登录<br/>
 *Create info: hongyang.zhao, 2019年4月28日 <br/>
 *Copyright (c) 2019, RunTong Information Technology Co.,Ltd. All Rights Reserved. <br/>
 *@author hongyang.zhao
 *@Version 1.0
 */
public interface UserLogInOutService {

	
	LoginRes login(LoginReq req,HttpServletRequest request, HttpServletResponse response);

}