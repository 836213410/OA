package com.rt.modules.department.service.impl;



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
import com.rt.modules.department.dto.req.QryPgDepartmentReq;
import com.rt.modules.department.dto.vo.DepartmentVo;
import com.rt.modules.department.mapper.DepartmentMapper;
import com.rt.modules.department.po.DepartmentPo;
import com.rt.modules.department.service.QryDepartmentService;

/** 
 *Description: [department]管理接口实现类 <br/>
 *Generate by Wanpeng.Hui's Pengpeng-Generator 2019/04/26 <br/>
 *Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 *@Version 1.0
 */
 @Service
public class QryDepartmentServiceImpl implements QryDepartmentService{
	
	@Autowired
	private DepartmentMapper departmentMapper; // Mapper
	private static Logger logger = LoggerFactory.getLogger(QryDepartmentServiceImpl.class); // 记录日志
	
	@Override
    @Transactional(readOnly = true)
	public QryObjRes<DepartmentVo> getDepartmentVoById(Long id){
	    QryObjRes<DepartmentVo> res = new QryObjRes<DepartmentVo>();
		
		DepartmentPo po = departmentMapper.findObjByPk(id); // 从数据库查询
		if(null == po) {
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("未找到对象, 请检查参数是否正确");
			logger.info("根据ID{}未找到对象", id);
			return res;
		}
		
	    DepartmentVo departmentVo = new DepartmentVo();
		departmentVo.setId(po.getId()); // 部门id
		departmentVo.setDeptName(po.getDeptName()); // 部门名岑
		departmentVo.setChiefId(po.getChiefId()); // 部门总监
		departmentVo.setManageId(po.getManageId()); // 部门经理
		departmentVo.setTotalNum(po.getTotalNum()); // 部门编制人数
		departmentVo.setRealNum(po.getRealNum()); // 实际在职人数
		departmentVo.setDltFlg(po.getDltFlg()); // 是否使用
		departmentVo.setRmk(po.getRmk()); // 备注
		departmentVo.setCrtTm(po.getCrtTm()); // 创建时间
		departmentVo.setUptTm(po.getUptTm()); // 更新时间
		
		res.setObj(departmentVo); // 设置对象
		res.setResCode(ResConstant.OPR_SUCC_QUIET);
		res.setResMsg("查找根据ID查找对象成功");
		logger.info("查找根据ID{}查找对象成功", id);
		return res;
	}

    @Override
    @Transactional(readOnly = true)
    public QryPgBaseRes<DepartmentVo> qryPgDepartment(QryPgDepartmentReq req){
        QryPgBaseRes<DepartmentVo> res = new QryPgBaseRes<DepartmentVo>();
      
        // 记录传入参数, 以方便调试
	
        HashMap<String, Object> conditionMap = new HashMap<String, Object>();
  
		int total = departmentMapper.queryCountByMap(conditionMap); // 统计条数
		if (total > 0) {
			// 从数据库查询
			List<DepartmentPo> departmentPoLst = departmentMapper.queryPageByMap(conditionMap,
					new RowBounds(req.getOffset(), req.getLimit()));

			List<DepartmentVo> departmentVoLst = new ArrayList<DepartmentVo>();
			DepartmentVo departmentVo = null;
			for (DepartmentPo po : departmentPoLst) {
				departmentVo = new DepartmentVo();
				
				// 从PO向VO设值
				departmentVo.setId(po.getId()); // 部门id
				departmentVo.setDeptName(po.getDeptName()); // 部门名岑
				departmentVo.setChiefId(po.getChiefId()); // 部门总监
				departmentVo.setManageId(po.getManageId()); // 部门经理
				departmentVo.setTotalNum(po.getTotalNum()); // 部门编制人数
				departmentVo.setRealNum(po.getRealNum()); // 实际在职人数
				departmentVo.setDltFlg(po.getDltFlg()); // 是否使用
				departmentVo.setRmk(po.getRmk()); // 备注
				departmentVo.setCrtTm(po.getCrtTm()); // 创建时间
				departmentVo.setUptTm(po.getUptTm()); // 更新时间
				
				departmentVoLst.add(departmentVo); // 加入集合
			}
			res.setCount(total); //设置统计条数
			res.setData(departmentVoLst); // 设置VO集合
		}
		
		res.setResCode(ResConstant.OPR_SUCC_QUIET);
		res.setResMsg("执行查询操作成功");
		logger.info("查询操作成功");
		return res;
    } 
}
