package com.rt.modules.setting.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.rt.global.database.BaseMapper;
import com.rt.modules.setting.po.PubDictPo;


/**
 *系统字典表[pub_dict]Mapper
 *Generate by Wanpeng.Hui's Dapeng-Generator <br/>
 *Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 */
@Repository
public interface PubDictMapper extends BaseMapper<PubDictPo, Long> {

	/**
	 *根据字典名和条目值查询值条目键
	 * @param 
	 * @return
	 */
	String  getDictItmKey(@Param("dictNm") String dictNm,@Param("itmVal") String itmVal);
}