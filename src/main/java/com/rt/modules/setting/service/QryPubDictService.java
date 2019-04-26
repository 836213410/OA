package com.rt.modules.setting.service;

import com.rt.global.dto.QryObjRes;
import com.rt.global.dto.QryPgBaseRes;
import com.rt.modules.setting.dto.req.QryDictKeyReq;
import com.rt.modules.setting.dto.req.QryPgPubDictReq;
import com.rt.modules.setting.dto.res.QryDictKeyRes;
import com.rt.modules.setting.dto.vo.PubDictVo;

/** 
 * Description: 查询系统字典表[pub_dict]接口 <br/>
 * Generate by Wanpeng.Hui's Dapeng-Generator 2019/04/26 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
public interface QryPubDictService {
	
	
	/** 
	 * Description: 根据ID查询对象 <br/>
	 * Create info: Wanpeng.Hui, 2019/04/26  <br/>
	 *
	 * @param req
	 * @return 
	 */
	public QryObjRes<PubDictVo> getPubDictVoById(Long id);
	
    /** 
     * Description: 执行分页查询 <br/>
     * Create info: Wanpeng.Hui, 2019/04/26 <br/>
     *
     * @param req
     * @return 
     */
    public QryPgBaseRes<PubDictVo> qryPgPubDict(QryPgPubDictReq req);
    /** 
     * Description: 字典数据项值翻译服务接口 <br/>
     * Create info: Wanpeng.Hui, 2018/04/09 <br/>
     *
     * @param req
     * @return
     */
    public QryDictKeyRes getDictItmKey(QryDictKeyReq req);
} 
