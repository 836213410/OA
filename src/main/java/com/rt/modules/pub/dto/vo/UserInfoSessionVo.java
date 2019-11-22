package com.rt.modules.pub.dto.vo;

/** 
 *Description: 用户会话对象<br/>
 *Create info: hongyang.zhao, 2019年4月28日 <br/>
 *Copyright (c) 2019, RunTong Information Technology Co.,Ltd. All Rights Reserved. <br/>
 *@author hongyang.zhao
 *@Version 1.0
 */
public class UserInfoSessionVo {
	private Long id; // 用户ID
	private String username; // 用户名
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
}