package com.rt.modules.pub.service;

import com.rt.global.dto.BaseRes;
import com.rt.modules.pub.dto.req.CrtUptUserReq;

/** 
 * Description: 修改[user]接口 <br/>
 * Generate by Wanpeng.Hui's Dapeng-Generator 2019/04/21 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
public interface CrtUptUserService {
	
    /** 
     * Description: 执行创建<br/>
     * Create info: Wanpeng.Hui, 2019/04/21  <br/>
     *
     * @param req
     * @return 
     */
    public BaseRes crtUser(CrtUptUserReq req);

	
    /** 
     * Description: 执行修改<br/>
     * Create info: Wanpeng.Hui, 2019/04/21  <br/>
     *
     * @param req
     * @return 
     */
    public BaseRes uptUser(CrtUptUserReq req);
    
}
