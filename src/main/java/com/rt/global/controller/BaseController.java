package com.rt.global.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rt.global.dto.ExceptionBaseRes;
import com.rt.global.exception.CommonException;


/**
 * 
 *Description:Base controller<br/>
 *Create info: hongyang.zhao, 2019年4月21日 <br/>
 *Copyright (c) 2019, Hema Information Technology Co.,Ltd. All Rights Reserved. <br/>
 *
 *@Version 1.0
 */

public class BaseController {
	private static Logger logger = LoggerFactory.getLogger(BaseController.class);

	/**
	 * Description: 异常处理器, 把异常信息转换成前端能识别的通用json格式<br/>
	 * Create info: wanpeng.hui, 2018年4月1日 <br/>
	 *
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	public @ResponseBody ExceptionBaseRes exceptionHandle(HttpServletRequest request, Exception exception) {

		ExceptionBaseRes baseExceptionRes = new ExceptionBaseRes();
		if (exception instanceof CommonException) {
			// 通用业务异常
			CommonException commonException = (CommonException) exception;
			baseExceptionRes.setResCode(commonException.getErrorCode());
			baseExceptionRes.setResMsg(commonException.getMessage());

			logger.error(commonException.getAllInfo());
		} else {
			// 其它异常信息
			baseExceptionRes.setResCode("EE000099");
			baseExceptionRes.setResMsg(exception.getMessage());

			logger.error(ExceptionUtils.getStackTrace(exception));
		}

		return baseExceptionRes;
	}
}
