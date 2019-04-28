package com.rt.modules.pub.dto.res;

import com.rt.global.dto.BaseRes;
import com.rt.modules.pub.dto.vo.UserInfoSessionVo;


/** 
 *Description: 登陆响应<br/>
 *Create info: hongyang.zhao, 2019年4月28日 <br/>
 *Copyright (c) 2019, RunTong Information Technology Co.,Ltd. All Rights Reserved. <br/>
 *@author hongyang.zhao
 *@Version 1.0
 */
public class LoginRes extends BaseRes {
	private UserInfoSessionVo userInfoSessionVo; // 用户会话对象

	public UserInfoSessionVo getUserInfoSessionVo() {
		return userInfoSessionVo;
	}

	public void setUserInfoSessionVo(UserInfoSessionVo userInfoSessionVo) {
		this.userInfoSessionVo = userInfoSessionVo;
	}
}