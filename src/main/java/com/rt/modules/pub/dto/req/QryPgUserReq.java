package com.rt.modules.pub.dto.req;

import com.rt.global.dto.QryPgBaseReq;

/** 
 * Description: 执行查询请求, 成员变量为查询条件 <br/>
 * Generate by Wanpeng.Hui's Pengpeng-Generator 2019/04/21 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
public class QryPgUserReq extends QryPgBaseReq {
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
