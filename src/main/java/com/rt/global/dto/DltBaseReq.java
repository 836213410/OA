package com.rt.global.dto;

/** 
 *Description: 删除基类<br/>
 *Create info: hongyang.zhao, 2019年4月16日 <br/>
 *Copyright (c) 2019, RunTong Information Technology Co.,Ltd. All Rights Reserved. <br/>
 *@author hongyang.zhao
 *@Version 1.0
 */
public class DltBaseReq extends BaseReq {
    private Long id; // 主键
    private Integer dltTp; // 删除类型
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getDltTp() {
		return dltTp;
	}
	public void setDltTp(Integer dltTp) {
		this.dltTp = dltTp;
	}
}
