package com.rt.modules.pub.dto.req;

import com.rt.global.dto.BaseReq;

/** 
 *Description: <br/>
 *Create info: hongyang.zhao, 2019年4月28日 <br/>
 *Copyright (c) 2019, RunTong Information Technology Co.,Ltd. All Rights Reserved. <br/>
 *@author hongyang.zhao
 *@Version 1.0
 */
public class LoginReq extends BaseReq{

	private String username;//用户名
	private String password;//密码
	private String veriCode;//验证码
	private String rememberMe;//记住我
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVeriCode() {
		return veriCode;
	}
	public void setVeriCode(String veriCode) {
		this.veriCode = veriCode;
	}
	public String getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}
	
	
	
}
