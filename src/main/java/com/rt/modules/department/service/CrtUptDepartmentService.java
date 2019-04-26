package com.rt.modules.department.service;

import com.rt.global.dto.BaseRes;
import com.rt.modules.department.dto.req.CrtUptDepartmentReq;

/** 
 * Description: 修改[department]接口 <br/>
 * Generate by Wanpeng.Hui's Dapeng-Generator 2019/04/26 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
public interface CrtUptDepartmentService {
	
    /** 
     * Description: 执行创建<br/>
     * Create info: Wanpeng.Hui, 2019/04/26  <br/>
     *
     * @param req
     * @return 
     */
    public BaseRes crtDepartment(CrtUptDepartmentReq req);

	
    /** 
     * Description: 执行修改<br/>
     * Create info: Wanpeng.Hui, 2019/04/26  <br/>
     *
     * @param req
     * @return 
     */
    public BaseRes uptDepartment(CrtUptDepartmentReq req);
    
}
