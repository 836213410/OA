package com.rt.modules.pub.service;

import com.rt.global.dto.QryObjRes;
import com.rt.global.dto.QryPgBaseRes;
import com.rt.modules.pub.dto.req.QryPgUserReq;
import com.rt.modules.pub.dto.vo.UserVo;

/** 
 * Description: 查询[user]接口 <br/>
 * Generate by Wanpeng.Hui's Dapeng-Generator 2019/04/21 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
public interface QryUserService {
	
	
	/** 
	 * Description: 根据ID查询对象 <br/>
	 * Create info: Wanpeng.Hui, 2019/04/21  <br/>
	 *
	 * @param req
	 * @return 
	 */
	public QryObjRes<UserVo> getUserVoById(Long id);
	
    /** 
     * Description: 执行分页查询 <br/>
     * Create info: Wanpeng.Hui, 2019/04/21 <br/>
     *
     * @param req
     * @return 
     */
    public QryPgBaseRes<UserVo> qryPgUser(QryPgUserReq req);
} 
