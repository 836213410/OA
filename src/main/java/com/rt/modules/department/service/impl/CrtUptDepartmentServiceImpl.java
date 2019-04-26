package com.rt.modules.department.service.impl;



import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rt.global.constant.ResConstant;
import com.rt.global.dto.BaseRes;
import com.rt.modules.department.dto.req.CrtUptDepartmentReq;
import com.rt.modules.department.mapper.DepartmentMapper;
import com.rt.modules.department.po.DepartmentPo;
import com.rt.modules.department.service.CrtUptDepartmentService;

/** 
 * Description: 修改[department]管理接口实现类 <br/>
 * Generate by Wanpeng.Hui's Pengpeng-Generator 2019/04/26 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
@Service
public class CrtUptDepartmentServiceImpl implements CrtUptDepartmentService{
	
	@Autowired
	private DepartmentMapper departmentMapper; // Mapper
	
	private static Logger logger = LoggerFactory.getLogger(CrtUptDepartmentServiceImpl.class); // 记录日志
   
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public BaseRes crtDepartment(CrtUptDepartmentReq req) {
		return crtUptDepartment(req, true); // 执行添加
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public BaseRes uptDepartment(CrtUptDepartmentReq req) {
		return crtUptDepartment(req, false); // 执行修改
	}
    
    /**
	 * Description: 执行添加或修改<br/>
	 * Create info: Wanpeng.Hui, 2019/04/26  <br/>
	 *
	 * @param req
	 * @param isCreate
	 * @return
	 */
    private BaseRes crtUptDepartment(CrtUptDepartmentReq req, boolean isCreate){
        BaseRes res = new BaseRes();

        checkPara(req, res, isCreate); // 检查参数
		if (ResConstant.OPR_FAIL_PARAMETER.equals(res.getResCode())) {
			return res;
		}

		DepartmentPo departmentPo = null;
 		if (isCreate) {
 		    // 创建PO对象并组装参数
 			departmentPo = new DepartmentPo();
			//departmentPo.setId(genIdFcService.genIdn(0));  // 部门id
 		} else {
 		    // 根据主键从数据库查找对象
 			departmentPo = departmentMapper.findObjByPk(req.getId());
 			
 			// 如果未能查到对象, 运回错误信息
 			if (departmentPo == null) {
 				res.setResCode(ResConstant.OPR_FAIL);
 				res.setResMsg("根据主键" + req.getId() + "找不到对象");
 				logger.error("根据主键{}找不到对象", req.getId());
 				return res;
 			}
 		}
		
 		departmentPo.setDeptName(req.getDeptName()); // 部门名岑
 		departmentPo.setChiefId(req.getChiefId()); // 部门总监
 		departmentPo.setManageId(req.getManageId()); // 部门经理
 		departmentPo.setTotalNum(req.getTotalNum()); // 部门编制人数
 		departmentPo.setRealNum(req.getRealNum()); // 实际在职人数
 		departmentPo.setDltFlg(req.getDltFlg()); // 是否使用
 		departmentPo.setRmk(req.getRmk()); // 备注
 		departmentPo.setCrtTm(req.getCrtTm()); // 创建时间
 		departmentPo.setUptTm(req.getUptTm()); // 更新时间
		
		if(isCreate){
		    departmentMapper.insert(departmentPo); // 执行插入
 			logger.info("添加成功, 返回主键: {}", departmentPo.getId()); // 跟踪日志
		}
		else{
		    departmentMapper.updateByPk(departmentPo); // 执行修改
 			logger.info("修改数据");
		}
    
         // 设置响应结果码
         res.setResCode(ResConstant.OPR_SUCC);
    	 res.setResMsg("执行修改操作成功");
		 return res;
    }
    
    /**
	 * Description: 检查参数 <br/>
	 * Create info: Wanpeng.Hui, 2019/04/26  <br/>
	 *
	 * @return
	 */
	private void checkPara(CrtUptDepartmentReq req, BaseRes res, boolean isCreate) {

		// 检查参数-主键, 修改时不能为空
        if(!isCreate && null == req.getId()){
            res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("部门id必填");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-部门名岑不能为空
        if(StringUtils.isEmpty(req.getDeptName())){
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("部门名岑必填");
			logger.warn(res.getResMsg());
			return;
		}
	    // 检查参数-部门名岑长度限制
	    if(req.getDeptName().length()>7){
	        res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("部门名岑参数太长");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-部门编制人数不能为空
		if(null == req.getTotalNum()){
            res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("部门编制人数必填");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-实际在职人数不能为空
		if(null == req.getRealNum()){
            res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("实际在职人数必填");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-是否使用不能为空
		if(null == req.getDltFlg()){
            res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("是否使用必填");
			logger.warn(res.getResMsg());
			return;
		}
	}
}
