package com.rt.modules.setting.service;

import com.rt.global.dto.BaseRes;
import com.rt.global.dto.DltBaseReq;

/** 
 * Description: 删除系统字典表[pub_dict]接口(逻辑删除, 恢复逻辑删除, 物理删除) <br/>
 * Generate by Wanpeng.Hui's Dapeng-Generator 2019/04/26 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
public interface DltPubDictService {
   
    /** 
     * Description: 逻辑删除 <br/>
     * Create info: Wanpeng.Hui, 2019/04/26  <br/>
     *
     * @param req
     * @return 
     */
    public BaseRes dltLgcPubDict(DltBaseReq req);

    /** 
     * Description: 恢复逻辑删除 <br/>
     * Create info: Wanpeng.Hui, 2019/04/26  <br/>
     *
     * @param req
     * @return 
     */
    public BaseRes dltRvtPubDict(DltBaseReq req);

	/** 
     * Description: 物理删除 <br/>
     * Create info: Wanpeng.Hui, 2019/04/26  <br/>
     *
     * @param req
     * @return 
     */
    public BaseRes dltPscPubDict(DltBaseReq req);

}
