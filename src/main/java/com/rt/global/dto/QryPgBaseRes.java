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
	private int total = 0;
	/** 本页记录 */
	protected List<T> rows = new ArrayList<T>();

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
