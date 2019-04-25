package com.rt.global.dto;

import java.util.ArrayList;
import java.util.List;

/** 
 *Description: 分页响应基类<br/>
 *Create info: hongyang.zhao, 2019年4月16日 <br/>
 *Copyright (c) 2019, RunTong Information Technology Co.,Ltd. All Rights Reserved. <br/>
 *@author hongyang.zhao
 *@Version 1.0
 */
public class QryPgBaseRes<T> extends BaseRes {
	/** 符合条件记录数量 */
	private int count = 0;
	/** 本页记录 */
	protected List<T> data = new ArrayList<T>();
	private int code = 0;
	
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}

	

}
