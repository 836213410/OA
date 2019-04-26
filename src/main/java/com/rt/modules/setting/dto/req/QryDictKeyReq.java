package com.rt.modules.setting.dto.req;

import com.rt.global.dto.BaseReq;


/** 
 *Description: 字典数据项值翻译Req<br/>
 *Create info: hongyang.zhao, 2018年4月13日 <br/>
 *Copyright (c) 2018, Hema Information Technology Co.,Ltd. All Rights Reserved. <br/>
 *
 *@Version 1.0
 */
public class QryDictKeyReq extends BaseReq{

	private String dictNm;//字典名称
	private String itmVal;//条目值
	
	public QryDictKeyReq() {}
	
	public QryDictKeyReq(String dictNm, String itmVal) {
		this.dictNm = dictNm;
		this.itmVal = itmVal;
	}
	
	public String getDictNm() {
		return dictNm;
	}
	public void setDictNm(String dictNm) {
		this.dictNm = dictNm;
	}
	public String getItmVal() {
		return itmVal;
	}
	public void setItmVal(String itmVal) {
		this.itmVal = itmVal;
	}
	
	
	
	
}
