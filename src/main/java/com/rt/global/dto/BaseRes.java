package com.rt.global.dto;

import com.rt.global.constant.ResConstant;

/** 
 *Description: 响应基类<br/>
 *Create info: hongyang.zhao, 2019年4月16日 <br/>
 *Copyright (c) 2019, RunTong Information Technology Co.,Ltd. All Rights Reserved. <br/>
 *@author hongyang.zhao
 *@Version 1.0
 */
public class BaseRes {

	/** 响应码 */
	private String resCode = ResConstant.OPR_SUCC;
	/** 响应消息 */
	private String resMsg = "操作成功";

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
}
