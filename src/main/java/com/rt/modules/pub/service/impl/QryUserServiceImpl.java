package com.rt.modules.pub.service.impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rt.global.constant.ResConstant;
import com.rt.global.dto.QryObjRes;
import com.rt.global.dto.QryPgBaseRes;
import com.rt.modules.pub.dto.req.QryPgUserReq;
import com.rt.modules.pub.dto.vo.UserVo;
import com.rt.modules.pub.mapper.UserMapper;
import com.rt.modules.pub.po.UserPo;
import com.rt.modules.pub.service.QryUserService;

/** 
 *Description: [user]管理接口实现类 <br/>
 *Generate by Wanpeng.Hui's Pengpeng-Generator 2019/04/21 <br/>
 *Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 *@Version 1.0
 */
 @Service
public class QryUserServiceImpl implements QryUserService{
	
	@Autowired
	private UserMapper userMapper; // Mapper
	private static Logger logger = LoggerFactory.getLogger(QryUserServiceImpl.class); // 记录日志
	
	@Override
    @Transactional(readOnly = true)
	public QryObjRes<UserVo> getUserVoById(Long id){
	    QryObjRes<UserVo> res = new QryObjRes<UserVo>();
		
		UserPo po = userMapper.findObjByPk(id); // 从数据库查询
		if(null == po) {
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("未找到对象, 请检查参数是否正确");
			logger.info("根据ID{}未找到对象", id);
			return res;
		}
		
	    UserVo userVo = new UserVo();
		userVo.setId(po.getId()); 
		userVo.setName(po.getName()); 
		
		res.setObj(userVo); // 设置对象
		res.setResCode(ResConstant.OPR_SUCC_QUIET);
		res.setResMsg("查找根据ID查找对象成功");
		logger.info("查找根据ID{}查找对象成功", id);
		return res;
	}

    @Override
    @Transactional(readOnly = true)
    public QryPgBaseRes<UserVo> qryPgUser(QryPgUserReq req){
        QryPgBaseRes<UserVo> res = new QryPgBaseRes<UserVo>();
      
        // 记录传入参数, 以方便调试
	
        HashMap<String, Object> conditionMap = new HashMap<String, Object>();
  
		int total = userMapper.queryCountByMap(conditionMap); // 统计条数
		if (total > 0) {
			// 从数据库查询
			List<UserPo> userPoLst = userMapper.queryPageByMap(conditionMap,
					new RowBounds(req.getOffset(), req.getLimit()));

			List<UserVo> userVoLst = new ArrayList<UserVo>();
			UserVo userVo = null;
			for (UserPo po : userPoLst) {
				userVo = new UserVo();
				
				// 从PO向VO设值
				userVo.setId(po.getId()); 
				userVo.setName(po.getName()); 
				
				userVoLst.add(userVo); // 加入集合
			}
			res.setTotal(total); //设置统计条数
			res.setRows(userVoLst); // 设置VO集合
		}
		
		res.setResCode(ResConstant.OPR_SUCC_QUIET);
		res.setResMsg("执行查询操作成功");
		logger.info("查询操作成功");
		return res;
    } 
}
