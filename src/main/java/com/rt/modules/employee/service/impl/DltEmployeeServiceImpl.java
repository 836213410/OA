package com.rt.modules.employee.service.impl;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rt.global.constant.ResConstant;
import com.rt.global.dto.BaseRes;
import com.rt.global.dto.DltBaseReq;
import com.rt.modules.employee.mapper.EmployeeMapper;
import com.rt.modules.employee.po.EmployeePo;
import com.rt.modules.employee.service.DltEmployeeService;

/** 
 * Description: 删除[employee]接口(逻辑删除, 恢复逻辑删除, 物理删除) <br/>
 * Generate by Wanpeng.Hui's Dapeng-Generator 2019/04/23 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
 @Service
public class DltEmployeeServiceImpl implements DltEmployeeService{
	
	@Autowired
	private EmployeeMapper employeeMapper; // Mapper 
	private static Logger logger = LoggerFactory.getLogger(DltEmployeeServiceImpl.class); // 记录日志
   
    @Override
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public BaseRes dltLgcEmployee(DltBaseReq req){
	    return oprtEmployee(req, 1); // 操作类型为逻辑删除
	}

	@Override
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public BaseRes dltRvtEmployee(DltBaseReq req){
        return oprtEmployee(req, 2); // 操作类型为恢复删除
	}

	@Override
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public BaseRes dltPscEmployee(DltBaseReq req){
        return oprtEmployee(req, 0); // 操作类型为物理删除
	}

	/** 
     * Description: 操作类型:0:物理删除, 1:逻辑删除, 2:逻辑恢复 <br/>
     * Create info: Wanpeng.Hui, 2019/04/23  <br/>
     *
     * @param req
	 * @param oprtType
     */
    private BaseRes oprtEmployee(DltBaseReq req, int oprtType){
		BaseRes res = new BaseRes();

        // 检查参数
		if (null == req) {
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("请求参数为null");
			logger.error("请求参数为null");
			return res;
		}

	    // 检查主键, 主键为空时不能删除
		if (null == req.getId()) {
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("主键不能为空");
			logger.error("主键不能为空");
			return res;
		}

	    logger.debug("操作主键:{}", req.getId()); // 主键
		logger.debug("操作类型:{}", oprtType); // 操作类型

		// 检查要删除的对象是否存在
		EmployeePo dbEmployeePo = employeeMapper.findObjByPk(req.getId());
		if(null == dbEmployeePo) {
			res.setResCode(ResConstant.OPR_FAIL);
			res.setResMsg("根据主键 " + req.getId() + "找不到要删除的对象");
			logger.error("根据主键 {}, 找不到对象要删除的对象", req.getId());
			return res;
		}

		// 物理删除
		if (0 == oprtType) {
			employeeMapper.deleteByPk(req.getId());
			res.setResMsg("物理删除成功");
		}
		// 逻辑删除
		else if (1 == oprtType) {
			dbEmployeePo.setDltFlg((short)1);
			employeeMapper.updateByPk(dbEmployeePo);
			res.setResMsg("逻辑删除成功");
		}
		// 恢复删除
		else {
			dbEmployeePo.setDltFlg((short)0);
			employeeMapper.updateByPk(dbEmployeePo);
			res.setResMsg("恢复删除成功");
			return res;
		}

		res.setResCode(ResConstant.OPR_SUCC);
		return res;
	}
}
