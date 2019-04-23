package com.rt.modules.employee.service;

import com.rt.global.dto.QryObjRes;
import com.rt.global.dto.QryPgBaseRes;
import com.rt.modules.employee.dto.req.QryPgEmployeeReq;
import com.rt.modules.employee.dto.vo.EmployeeVo;

/** 
 * Description: 查询[employee]接口 <br/>
 * Generate by Wanpeng.Hui's Dapeng-Generator 2019/04/23 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
public interface QryEmployeeService {
	
	
	/** 
	 * Description: 根据ID查询对象 <br/>
	 * Create info: Wanpeng.Hui, 2019/04/23  <br/>
	 *
	 * @param req
	 * @return 
	 */
	public QryObjRes<EmployeeVo> getEmployeeVoById(Long id);
	
    /** 
     * Description: 执行分页查询 <br/>
     * Create info: Wanpeng.Hui, 2019/04/23 <br/>
     *
     * @param req
     * @return 
     */
    public QryPgBaseRes<EmployeeVo> qryPgEmployee(QryPgEmployeeReq req);
} 
