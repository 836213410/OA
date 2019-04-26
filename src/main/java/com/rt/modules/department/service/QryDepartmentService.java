package com.rt.modules.department.service;

import com.rt.global.dto.QryObjRes;
import com.rt.global.dto.QryPgBaseRes;
import com.rt.modules.department.dto.req.QryPgDepartmentReq;
import com.rt.modules.department.dto.vo.DepartmentVo;

/** 
 * Description: 查询[department]接口 <br/>
 * Generate by Wanpeng.Hui's Dapeng-Generator 2019/04/26 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
public interface QryDepartmentService {
	
	
	/** 
	 * Description: 根据ID查询对象 <br/>
	 * Create info: Wanpeng.Hui, 2019/04/26  <br/>
	 *
	 * @param req
	 * @return 
	 */
	public QryObjRes<DepartmentVo> getDepartmentVoById(Long id);
	
    /** 
     * Description: 执行分页查询 <br/>
     * Create info: Wanpeng.Hui, 2019/04/26 <br/>
     *
     * @param req
     * @return 
     */
    public QryPgBaseRes<DepartmentVo> qryPgDepartment(QryPgDepartmentReq req);
} 
