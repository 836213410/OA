package com.rt.modules.setting.dto.res;

import com.rt.global.dto.BaseRes;


/** 
 *Description: 字典数据项值翻译Res<br/>
 *Create info: hongyang.zhao, 2018年4月13日 <br/>
 *Copyright (c) 2018, Hema Information Technology Co.,Ltd. All Rights Reserved. <br/>
 *
 *@Version 1.0
 */
public class QryDictKeyRes extends BaseRes{

	private String itmKey="";//字典条目

	public String getItmKey() {
		return itmKey;
	}

	public void setItmKey(String itmKey) {
		this.itmKey = itmKey;
	}
}
