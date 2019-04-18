package com.rt.modules.pub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	
	private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

	
	@ExceptionHandler(value = Exception.class)
	public String meetException() {
		log.info("控制层捕获到未手动捕获异常");
		return "exception";
	}
}
