package com.rt.modules.employee.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rt.global.controller.BaseController;
import com.rt.global.dto.BaseRes;
import com.rt.global.dto.DltBaseReq;
import com.rt.global.dto.QryObjRes;
import com.rt.global.dto.QryPgBaseRes;
import com.rt.modules.employee.dto.req.CrtUptEmployeeReq;
import com.rt.modules.employee.dto.req.QryPgEmployeeReq;
import com.rt.modules.employee.dto.vo.EmployeeVo;
import com.rt.modules.employee.service.CrtUptEmployeeService;
import com.rt.modules.employee.service.DltEmployeeService;
import com.rt.modules.employee.service.QryEmployeeService;


/** 
 * Description: [employee]控制器 <br/>
 * Generate by Wanpeng.Hui's Pengpeng-Generator 2019/04/23 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
@Controller
@RequestMapping("/employee")
public class EmployeeMgrController extends BaseController {

	@Autowired
	private QryEmployeeService qryEmployeeService; // 查询服务
	@Autowired
	private CrtUptEmployeeService crtUptEmployeeService;// 创建修改服务
	@Autowired
	private DltEmployeeService dltEmployeeService; // 删除服务
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeMgrController.class);
	
	
	@RequestMapping("/goEmplpyeePage")
	public String goEmplpyeePage() {
		return "/employee/employee";
	}
	
	
	/**
	 * Description: 执行查询 <br/>
	 * Create info: wanpeng.hui, 2017年7月24日 <br/>
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/qryPgEmployee")
	public @ResponseBody QryPgBaseRes<EmployeeVo> qryPgEmployee(QryPgEmployeeReq req) {
		logger.info("服务提供者, 进入查询");
		QryPgBaseRes<EmployeeVo> res = qryEmployeeService.qryPgEmployee(req);
		logger.info("服务提供者, 响应码:{}, 响应消息:{}", res.getResCode(), res.getResMsg());
		return res;
	}
	
	/** 
	 * Description: 根据主键查询对象 <br/>
	 * Create info: Wanpeng.Hui, 2018/04/09  <br/>
	 *
	 * @param req
	 * @return 
	 */
	@RequestMapping(value = "/getEmployeeVoById")
	public @ResponseBody QryObjRes<EmployeeVo> getEmployeeVoById(Long id){
	   logger.info("服务提供者, 根据{}查询对象", id);
	   return qryEmployeeService.getEmployeeVoById(id);
	}
	
	/**
	 * Description: 执行添加<br/>
	 * Create info: Wanpeng.Hui, 2019/04/23 <br/>
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/crtEmployee")
	public @ResponseBody BaseRes crtEmployee(CrtUptEmployeeReq req) {
		logger.info("服务提供者, 执行添加");
		BaseRes res = crtUptEmployeeService.crtEmployee(req);
		logger.info("服务提供者, 响应码:{}, 响应消息:{}", res.getResCode(), res.getResMsg());
		return res;
	}

	/**
	 * Description: 执行修改<br/>
	 * Create info: Wanpeng.Hui, 2019/04/23 <br/>
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/uptEmployee")
	public @ResponseBody BaseRes uptEmployee(CrtUptEmployeeReq req) {
		logger.info("服务提供者, 执行修改");
		BaseRes res = crtUptEmployeeService.uptEmployee(req);
		logger.info("服务提供者, 响应码:{}, 响应消息:{}", res.getResCode(), res.getResMsg());
		return res;
	}
	

	/**
	 * Description: 逻辑删除<br/>
     * Create info: Wanpeng.Hui, 2019/04/23 <br/>
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/dltLgcEmployee")
	public @ResponseBody BaseRes dltLgcEmployee(DltBaseReq req) {
		logger.info("执行逻辑删除");
		BaseRes res = dltEmployeeService.dltLgcEmployee(req);
		logger.info("响应码:{}, 响应消息:{}", res.getResCode(), res.getResMsg());
		return res;
	}

	/**
	 * Description: 在恢复逻辑删除<br/>
     * Create info: Wanpeng.Hui, 2019/04/23 <br/>
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/dltRvtEmployee")
	public @ResponseBody BaseRes dltRvtEmployee(DltBaseReq req) {
		logger.info("执行逻辑删除");
		BaseRes res = dltEmployeeService.dltRvtEmployee(req);
		logger.info("响应码:{}, 响应消息:{}", res.getResCode(), res.getResMsg());
		return res;
	}

	/**
	 * Description: 物理删除<br/>
	 * Create info: Wanpeng.Hui, 2019/04/23 <br/>
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/dltPscEmployee")
	public @ResponseBody BaseRes dltPscEmployee(DltBaseReq req) {
		logger.info("执行物理删除");
		BaseRes res = dltEmployeeService.dltPscEmployee(req);
		logger.info("响应码:{}, 响应消息:{}", res.getResCode(), res.getResMsg());
		return res;
	}
}
