package com.rt.global.dto;

import java.util.ArrayList;
import java.util.List;

/** 
 *Description: <br/>
 *Create info: hongyang.zhao, 2019年4月16日 <br/>
 *Copyright (c) 2019, RunTong Information Technology Co.,Ltd. All Rights Reserved. <br/>
 *@author hongyang.zhao
 *@Version 1.0
 */
public class ExceptionBaseRes extends BaseRes {

	/** 冗余属性, 只有查询型响应需要赋值, 没有此属性, datagrid不能正确装载, 不能正确提示异常信息 */
	private int total = 0;
	/** 冗余属性, 只有查询型响应需要赋值, 没有此属性, datagrid不能正确装载, 不能正确提示异常信息 */
	private List<Object> rows = new ArrayList<Object>();

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Object> getRows() {
		return rows;
	}

	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
}
