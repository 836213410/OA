package com.rt.modules.pub.service;

import com.rt.global.dto.BaseRes;
import com.rt.global.dto.DltBaseReq;

/** 
 * Description: 删除[user]接口(逻辑删除, 恢复逻辑删除, 物理删除) <br/>
 * Generate by Wanpeng.Hui's Dapeng-Generator 2019/04/21 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
public interface DltUserService {
   
    /** 
     * Description: 逻辑删除 <br/>
     * Create info: Wanpeng.Hui, 2019/04/21  <br/>
     *
     * @param req
     * @return 
     */
    public BaseRes dltLgcUser(DltBaseReq req);

    /** 
     * Description: 恢复逻辑删除 <br/>
     * Create info: Wanpeng.Hui, 2019/04/21  <br/>
     *
     * @param req
     * @return 
     */
    public BaseRes dltRvtUser(DltBaseReq req);

	/** 
     * Description: 物理删除 <br/>
     * Create info: Wanpeng.Hui, 2019/04/21  <br/>
     *
     * @param req
     * @return 
     */
    public BaseRes dltPscUser(DltBaseReq req);

}
