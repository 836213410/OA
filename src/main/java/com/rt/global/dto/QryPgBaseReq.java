package com.rt.global.dto;

import org.apache.ibatis.session.RowBounds;

/** 
 *Description: 分页请求基类<br/>
 *Create info: hongyang.zhao, 2019年4月16日 <br/>
 *Copyright (c) 2019, RunTong Information Technology Co.,Ltd. All Rights Reserved. <br/>
 *@author hongyang.zhao
 *@Version 1.0
 */
public class QryPgBaseReq extends BaseReq {
	private int page; // 当前页数
	private int rows; // 每页长度
	

	public void setPage(int page) {
		this.page = page < 1 ? 1 : page;
	}

	public void setRows(int rows) {
		this.rows = rows < 1 ? 1 : rows;
	}

	public int getLimit() {
		return rows;
	}

	public int getOffset() {
		return (page - 1) * rows;
	}

	public int getPage() {
		return page;
	}

	public int getRows() {
		return rows;
	}

	
	
	public RowBounds getRowBounds() {
		return new RowBounds(this.getOffset(), this.getLimit());
	}

	
	@Override
	public String toString() {
		return "QryPgBaseReq [page=" + page + ", rows=" + rows + "]";
	}
	
}
