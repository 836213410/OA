package com.rt.modules.setting.service;

import com.rt.global.dto.BaseRes;
import com.rt.modules.setting.dto.req.CrtUptPubDictReq;

/** 
 * Description: 修改系统字典表[pub_dict]接口 <br/>
 * Generate by Wanpeng.Hui's Dapeng-Generator 2019/04/26 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
public interface CrtUptPubDictService {
	
    /** 
     * Description: 执行创建<br/>
     * Create info: Wanpeng.Hui, 2019/04/26  <br/>
     *
     * @param req
     * @return 
     */
    public BaseRes crtPubDict(CrtUptPubDictReq req);

	
    /** 
     * Description: 执行修改<br/>
     * Create info: Wanpeng.Hui, 2019/04/26  <br/>
     *
     * @param req
     * @return 
     */
    public BaseRes uptPubDict(CrtUptPubDictReq req);
    
}
