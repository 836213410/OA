package com.rt.modules.pub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rt.modules.pub.mapper.UserMapper;
import com.rt.modules.pub.po.User;

@Controller
public class TestController {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/test")
	@ResponseBody
	public List<User> getAll(){
		return userMapper.getAll();
	}
	
}
