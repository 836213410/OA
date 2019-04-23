package com.rt.modules.employee.service.impl;



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
import com.rt.modules.employee.dto.req.QryPgEmployeeReq;
import com.rt.modules.employee.dto.vo.EmployeeVo;
import com.rt.modules.employee.mapper.EmployeeMapper;
import com.rt.modules.employee.po.EmployeePo;
import com.rt.modules.employee.service.QryEmployeeService;

/** 
 *Description: [employee]管理接口实现类 <br/>
 *Generate by Wanpeng.Hui's Pengpeng-Generator 2019/04/23 <br/>
 *Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 *@Version 1.0
 */
 @Service
public class QryEmployeeServiceImpl implements QryEmployeeService{
	
	@Autowired
	private EmployeeMapper employeeMapper; // Mapper
	private static Logger logger = LoggerFactory.getLogger(QryEmployeeServiceImpl.class); // 记录日志
	
	@Override
    @Transactional(readOnly = true)
	public QryObjRes<EmployeeVo> getEmployeeVoById(Long id){
	    QryObjRes<EmployeeVo> res = new QryObjRes<EmployeeVo>();
		
		EmployeePo po = employeeMapper.findObjByPk(id); // 从数据库查询
		if(null == po) {
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("未找到对象, 请检查参数是否正确");
			logger.info("根据ID{}未找到对象", id);
			return res;
		}
		
	    EmployeeVo employeeVo = new EmployeeVo();
		employeeVo.setId(po.getId()); // 员工id
		employeeVo.setUsername(po.getUsername()); // 用户名
		employeeVo.setRealname(po.getRealname()); // 真实姓名
		employeeVo.setEmail(po.getEmail()); // 电子邮件
		employeeVo.setMobile(po.getMobile()); 
		employeeVo.setAge(po.getAge()); // 年龄
		employeeVo.setSex(po.getSex()); // 性别 1为男0为女
		employeeVo.setHiredate(po.getHiredate()); // 入职时间
		employeeVo.setDeparturetime(po.getDeparturetime()); // 离职时间
		employeeVo.setStatus(po.getStatus()); // 在职状态，默认1在职，0离职
		employeeVo.setDepartmentId(po.getDepartmentId()); // 所属部门
		employeeVo.setEmployeeId(po.getEmployeeId()); // 直属领导
		employeeVo.setRmk(po.getRmk()); // 备注
		employeeVo.setJobnumber(po.getJobnumber()); // 工号
		employeeVo.setSalaryId(po.getSalaryId()); 
		employeeVo.setEdubg(po.getEdubg()); // 学历 1本科2大专3硕士4博士5大专以下
		employeeVo.setDltflg(po.getDltFlg()); // 删除类型
		employeeVo.setIdcard(po.getIdcard()); // 身份证号码
		
		res.setObj(employeeVo); // 设置对象
		res.setResCode(ResConstant.OPR_SUCC_QUIET);
		res.setResMsg("查找根据ID查找对象成功");
		logger.info("查找根据ID{}查找对象成功", id);
		return res;
	}

    @Override
    @Transactional(readOnly = true)
    public QryPgBaseRes<EmployeeVo> qryPgEmployee(QryPgEmployeeReq req){
        QryPgBaseRes<EmployeeVo> res = new QryPgBaseRes<EmployeeVo>();
      
        // 记录传入参数, 以方便调试
	
        HashMap<String, Object> conditionMap = new HashMap<String, Object>();
  
		int total = employeeMapper.queryCountByMap(conditionMap); // 统计条数
		if (total > 0) {
			// 从数据库查询
			List<EmployeePo> employeePoLst = employeeMapper.queryPageByMap(conditionMap,
					new RowBounds(req.getOffset(), req.getLimit()));

			List<EmployeeVo> employeeVoLst = new ArrayList<EmployeeVo>();
			EmployeeVo employeeVo = null;
			for (EmployeePo po : employeePoLst) {
				employeeVo = new EmployeeVo();
				
				// 从PO向VO设值
				employeeVo.setId(po.getId()); // 员工id
				employeeVo.setUsername(po.getUsername()); // 用户名
				employeeVo.setRealname(po.getRealname()); // 真实姓名
				employeeVo.setEmail(po.getEmail()); // 电子邮件
				employeeVo.setMobile(po.getMobile()); 
				employeeVo.setAge(po.getAge()); // 年龄
				employeeVo.setSex(po.getSex()); // 性别 1为男0为女
				employeeVo.setHiredate(po.getHiredate()); // 入职时间
				employeeVo.setDeparturetime(po.getDeparturetime()); // 离职时间
				employeeVo.setStatus(po.getStatus()); // 在职状态，默认1在职，0离职
				employeeVo.setDepartmentId(po.getDepartmentId()); // 所属部门
				employeeVo.setEmployeeId(po.getEmployeeId()); // 直属领导
				employeeVo.setRmk(po.getRmk()); // 备注
				employeeVo.setJobnumber(po.getJobnumber()); // 工号
				employeeVo.setSalaryId(po.getSalaryId()); 
				employeeVo.setEdubg(po.getEdubg()); // 学历 1本科2大专3硕士4博士5大专以下
				employeeVo.setDltflg(po.getDltFlg()); // 删除类型
				employeeVo.setIdcard(po.getIdcard()); // 身份证号码
				
				employeeVoLst.add(employeeVo); // 加入集合
			}
			res.setTotal(total); //设置统计条数
			res.setRows(employeeVoLst); // 设置VO集合
		}
		
		res.setResCode(ResConstant.OPR_SUCC_QUIET);
		res.setResMsg("执行查询操作成功");
		logger.info("查询操作成功");
		return res;
    } 
}
