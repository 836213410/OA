package com.rt.modules.employee.service;

import com.rt.global.dto.BaseRes;
import com.rt.modules.employee.dto.req.CrtUptEmployeeReq;

/** 
 * Description: 修改[employee]接口 <br/>
 * Generate by Wanpeng.Hui's Dapeng-Generator 2019/04/23 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
public interface CrtUptEmployeeService {
	
    /** 
     * Description: 执行创建<br/>
     * Create info: Wanpeng.Hui, 2019/04/23  <br/>
     *
     * @param req
     * @return 
     */
    public BaseRes crtEmployee(CrtUptEmployeeReq req);

	
    /** 
     * Description: 执行修改<br/>
     * Create info: Wanpeng.Hui, 2019/04/23  <br/>
     *
     * @param req
     * @return 
     */
    public BaseRes uptEmployee(CrtUptEmployeeReq req);
    
}
