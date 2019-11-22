package com.rt.modules.pub.service.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rt.global.constant.ResConstant;
import com.rt.global.dto.BaseRes;
import com.rt.modules.pub.dto.req.CrtUptUserReq;
import com.rt.modules.pub.mapper.UserMapper;
import com.rt.modules.pub.po.UserPo;
import com.rt.modules.pub.service.CrtUptUserService;

/** 
 * Description: 修改[user]管理接口实现类 <br/>
 * Generate by Wanpeng.Hui's Pengpeng-Generator 2019/04/21 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
@Service
public class CrtUptUserServiceImpl implements CrtUptUserService{
	
	@Autowired
	private UserMapper userMapper; // Mapper
	
	private static Logger logger = LoggerFactory.getLogger(CrtUptUserServiceImpl.class); // 记录日志
   
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public BaseRes crtUser(CrtUptUserReq req) {
		return crtUptUser(req, true); // 执行添加
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public BaseRes uptUser(CrtUptUserReq req) {
		return crtUptUser(req, false); // 执行修改
	}
    
    /**
	 * Description: 执行添加或修改<br/>
	 * Create info: Wanpeng.Hui, 2019/04/21  <br/>
	 *
	 * @param req
	 * @param isCreate
	 * @return
	 */
    private BaseRes crtUptUser(CrtUptUserReq req, boolean isCreate){
        BaseRes res = new BaseRes();

        checkPara(req, res, isCreate); // 检查参数
		if (ResConstant.OPR_FAIL_PARAMETER.equals(res.getResCode())) {
			return res;
		}

		UserPo userPo = null;
 		if (isCreate) {
 		    // 创建PO对象并组装参数
 			userPo = new UserPo();
 		} else {
 		    // 根据主键从数据库查找对象
 			userPo = userMapper.findObjByPk(req.getId());
 			
 			// 如果未能查到对象, 运回错误信息
 			if (userPo == null) {
 				res.setResCode(ResConstant.OPR_FAIL);
 				res.setResMsg("根据主键" + req.getId() + "找不到对象");
 				logger.error("根据主键{}找不到对象", req.getId());
 				return res;
 			}
 		}
		
 		userPo.setName(req.getName()); 
		
		if(isCreate){
		    userMapper.insert(userPo); // 执行插入
 			logger.info("添加成功, 返回主键: {}", userPo.getId()); // 跟踪日志
		}
		else{
		    userMapper.updateByPk(userPo); // 执行修改
 			logger.info("修改数据");
		}
    
         // 设置响应结果码
         res.setResCode(ResConstant.OPR_SUCC);
    	 res.setResMsg("执行修改操作成功");
		 return res;
    }
    
    /**
	 * Description: 检查参数 <br/>
	 * Create info: Wanpeng.Hui, 2019/04/21  <br/>
	 *
	 * @return
	 */
	private void checkPara(CrtUptUserReq req, BaseRes res, boolean isCreate) {

		// 检查参数-主键, 修改时不能为空
        if(!isCreate && null == req.getId()){
            res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("id必填");
			logger.warn(res.getResMsg());
			return;
		}
	}
}
