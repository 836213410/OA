package com.rt.global.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;


/** 
 *Description: 通用异常<br/>
 *Create info: hongyang.zhao, 2019年4月21日 <br/>
 *Copyright (c) 2019, Hema Information Technology Co.,Ltd. All Rights Reserved. <br/>
 *
 *@Version 1.0
 */
public class CommonException extends RuntimeException {
	private static final long serialVersionUID = -7238666009207875808L;

	/** 错误码 */
	private String errorCode;
	/** 错误消息 */
	private String errorMessage;
	/** 错误详细信息 */
	private String errorInfo;

	/**
	 * 构造方法1
	 */
	public CommonException(String errorCode, String errorMessage) {
		this(errorCode, errorMessage, null);
	}

	/**
	 * 构造方法2
	 */
	public CommonException(String errorCode, String errorMessage, Throwable throwable) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorInfo = throwable != null ? ExceptionUtils.getStackTrace(throwable) : "";
	}

	/**
	 * Description: 得到异常文字信息描述 <br/>
	 * Create info: wanpeng.hui, 2017/04/10 <br/>
	 *
	 * @return
	 */
	public String getAllInfo() {
		StringBuilder info = new StringBuilder();
		info.append("errorCode:");
		info.append(errorCode);
		info.append(", errorMessage:");
		info.append(errorMessage);
		info.append(", errorInfo:");
		info.append(errorInfo);
		return info.toString();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

}
