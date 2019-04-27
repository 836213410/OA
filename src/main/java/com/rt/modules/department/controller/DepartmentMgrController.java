package com.rt.modules.department.controller;



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
import com.rt.modules.department.dto.req.CrtUptDepartmentReq;
import com.rt.modules.department.dto.req.QryPgDepartmentReq;
import com.rt.modules.department.dto.vo.DepartmentVo;
import com.rt.modules.department.service.CrtUptDepartmentService;
import com.rt.modules.department.service.DltDepartmentService;
import com.rt.modules.department.service.QryDepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/** 
 * Description: [department]控制器 <br/>
 * Generate by Wanpeng.Hui's Pengpeng-Generator 2019/04/26 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
@Controller
@RequestMapping("/department")
@Api
public class DepartmentMgrController extends BaseController {

	@Autowired
	private QryDepartmentService qryDepartmentService; // 查询服务
	@Autowired
	private CrtUptDepartmentService crtUptDepartmentService;// 创建修改服务
	@Autowired
	private DltDepartmentService dltDepartmentService; // 删除服务
	
	private static Logger logger = LoggerFactory.getLogger(DepartmentMgrController.class);
	
	/**
	 * Description: 执行查询 <br/>
	 * Create info: wanpeng.hui, 2017年7月24日 <br/>
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/qryPgDepartment")
	@ApiOperation(value="部门分页查询接口")
	public @ResponseBody QryPgBaseRes<DepartmentVo> qryPgDepartment(QryPgDepartmentReq req) {
		logger.info("服务提供者, 进入查询");
		QryPgBaseRes<DepartmentVo> res = qryDepartmentService.qryPgDepartment(req);
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
	@RequestMapping(value = "/getDepartmentVoById")
	@ApiOperation(value="部门查询接口(ID)")
	public @ResponseBody QryObjRes<DepartmentVo> getDepartmentVoById(Long id){
	   logger.info("服务提供者, 根据{}查询对象", id);
	   return qryDepartmentService.getDepartmentVoById(id);
	}
	
	/**
	 * Description: 执行添加<br/>
	 * Create info: Wanpeng.Hui, 2019/04/26 <br/>
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/crtDepartment")
	@ApiOperation(value="增加部门接口")
	public @ResponseBody BaseRes crtDepartment(CrtUptDepartmentReq req) {
		logger.info("服务提供者, 执行添加");
		BaseRes res = crtUptDepartmentService.crtDepartment(req);
		logger.info("服务提供者, 响应码:{}, 响应消息:{}", res.getResCode(), res.getResMsg());
		return res;
	}

	/**
	 * Description: 执行修改<br/>
	 * Create info: Wanpeng.Hui, 2019/04/26 <br/>
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/uptDepartment")
	@ApiOperation(value="更新部门接口")
	public @ResponseBody BaseRes uptDepartment(CrtUptDepartmentReq req) {
		logger.info("服务提供者, 执行修改");
		BaseRes res = crtUptDepartmentService.uptDepartment(req);
		logger.info("服务提供者, 响应码:{}, 响应消息:{}", res.getResCode(), res.getResMsg());
		return res;
	}
	

	/**
	 * Description: 逻辑删除<br/>
     * Create info: Wanpeng.Hui, 2019/04/26 <br/>
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/dltLgcDepartment")
	public @ResponseBody BaseRes dltLgcDepartment(DltBaseReq req) {
		logger.info("执行逻辑删除");
		BaseRes res = dltDepartmentService.dltLgcDepartment(req);
		logger.info("响应码:{}, 响应消息:{}", res.getResCode(), res.getResMsg());
		return res;
	}

	/**
	 * Description: 在恢复逻辑删除<br/>
     * Create info: Wanpeng.Hui, 2019/04/26 <br/>
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/dltRvtDepartment")
	public @ResponseBody BaseRes dltRvtDepartment(DltBaseReq req) {
		logger.info("执行逻辑删除");
		BaseRes res = dltDepartmentService.dltRvtDepartment(req);
		logger.info("响应码:{}, 响应消息:{}", res.getResCode(), res.getResMsg());
		return res;
	}

	/**
	 * Description: 物理删除<br/>
	 * Create info: Wanpeng.Hui, 2019/04/26 <br/>
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/dltPscDepartment")
	@ApiOperation(value="删除部门接口")
	public @ResponseBody BaseRes dltPscDepartment(DltBaseReq req) {
		logger.info("执行物理删除");
		BaseRes res = dltDepartmentService.dltPscDepartment(req);
		logger.info("响应码:{}, 响应消息:{}", res.getResCode(), res.getResMsg());
		return res;
	}
}
