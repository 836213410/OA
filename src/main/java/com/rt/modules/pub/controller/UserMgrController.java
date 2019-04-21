package com.rt.modules.pub.controller;



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
import com.rt.modules.pub.dto.req.QryPgUserReq;
import com.rt.modules.pub.dto.vo.UserVo;
import com.rt.modules.pub.service.CrtUptUserService;
import com.rt.modules.pub.service.DltUserService;
import com.rt.modules.pub.service.QryUserService;


/** 
 * Description: [user]控制器 <br/>
 * Generate by Wanpeng.Hui's Pengpeng-Generator 2019/04/21 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
@Controller
@RequestMapping("/pub")
public class UserMgrController extends BaseController {

	
	private static final Logger logger = LoggerFactory.getLogger(UserMgrController.class);

	
	@Autowired
	private QryUserService qryUserService;
	@Autowired
	private DltUserService dltUserService;
	@Autowired
	private CrtUptUserService crtUptUserService;
  	
	

	/**
	 * 分页查询
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/qryPgUser")
	public @ResponseBody QryPgBaseRes<UserVo> qryPgUser(QryPgUserReq req) {
		logger.info("服务提供者, 进入查询");
		QryPgBaseRes<UserVo> res = qryUserService.qryPgUser(req);
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
	@RequestMapping(value = "/getUserVoById")
	public @ResponseBody QryObjRes<UserVo> getUserVoById(Long id){
	   logger.info("服务提供者, 根据{}查询对象", id);
	   return qryUserService.getUserVoById(id);
	}
	

	/**
	 * Description: 逻辑删除<br/>
     * Create info: Wanpeng.Hui, 2019/04/21 <br/>
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/dltLgcUser")
	public @ResponseBody BaseRes dltLgcUser(DltBaseReq req) {
		logger.info("执行逻辑删除");
		BaseRes res = dltUserService.dltLgcUser(req);
		logger.info("响应码:{}, 响应消息:{}", res.getResCode(), res.getResMsg());
		return res;
	}

	/**
	 * Description: 在恢复逻辑删除<br/>
     * Create info: Wanpeng.Hui, 2019/04/21 <br/>
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/dltRvtUser")
	public @ResponseBody BaseRes dltRvtUser(DltBaseReq req) {
		logger.info("执行逻辑删除");
		BaseRes res = dltUserService.dltRvtUser(req);
		logger.info("响应码:{}, 响应消息:{}", res.getResCode(), res.getResMsg());
		return res;
	}

	/**
	 * Description: 物理删除<br/>
	 * Create info: Wanpeng.Hui, 2019/04/21 <br/>
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/dltPscUser")
	public @ResponseBody BaseRes dltPscUser(DltBaseReq req) {
		logger.info("执行物理删除");
		BaseRes res = dltUserService.dltPscUser(req);
		logger.info("响应码:{}, 响应消息:{}", res.getResCode(), res.getResMsg());
		return res;
	}
	
	
}
