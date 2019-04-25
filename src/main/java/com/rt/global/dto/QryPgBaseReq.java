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
	private int limit; // 每页长度
	

	public void setPage(int page) {
		this.page = page < 1 ? 1 : page;
	}

	public void setlimit(int limit) {
		this.limit = limit < 1 ? 1 : limit;
	}

	public int getLimit() {
		return limit;
	}

	public int getOffset() {
		return (page - 1) * limit;
	}

	public int getPage() {
		return page;
	}

	
	
	
	public void setLimit(int limit) {
		this.limit = limit;
	}

	public RowBounds getRowBounds() {
		return new RowBounds(this.getOffset(), this.getLimit());
	}

	
	@Override
	public String toString() {
		return "QryPgBaseReq [page=" + page + ", limit=" + limit + "]";
	}
	
}
