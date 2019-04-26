package com.rt.modules.setting.service.impl;



import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rt.global.constant.ResConstant;
import com.rt.global.dto.BaseRes;
import com.rt.modules.setting.dto.req.CrtUptPubDictReq;
import com.rt.modules.setting.mapper.PubDictMapper;
import com.rt.modules.setting.po.PubDictPo;
import com.rt.modules.setting.service.CrtUptPubDictService;

/** 
 * Description: 修改系统字典表[pub_dict]管理接口实现类 <br/>
 * Generate by Wanpeng.Hui's Pengpeng-Generator 2019/04/26 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 * @Version 1.0
 */
@Service
public class CrtUptPubDictServiceImpl implements CrtUptPubDictService{
	
	@Autowired
	private PubDictMapper pubDictMapper; // 系统字典表Mapper
	
	private static Logger logger = LoggerFactory.getLogger(CrtUptPubDictServiceImpl.class); // 记录日志
   
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public BaseRes crtPubDict(CrtUptPubDictReq req) {
		return crtUptPubDict(req, true); // 执行添加
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public BaseRes uptPubDict(CrtUptPubDictReq req) {
		return crtUptPubDict(req, false); // 执行修改
	}
    
    /**
	 * Description: 执行添加或修改<br/>
	 * Create info: Wanpeng.Hui, 2019/04/26  <br/>
	 *
	 * @param req
	 * @param isCreate
	 * @return
	 */
    private BaseRes crtUptPubDict(CrtUptPubDictReq req, boolean isCreate){
        BaseRes res = new BaseRes();

        checkPara(req, res, isCreate); // 检查参数
		if (ResConstant.OPR_FAIL_PARAMETER.equals(res.getResCode())) {
			return res;
		}

		PubDictPo pubDictPo = null;
 		if (isCreate) {
 		    // 创建PO对象并组装参数
 			pubDictPo = new PubDictPo();
			//pubDictPo.setDictItmId(genIdFcService.genIdn(0));  // 字典条目ID
 		} else {
 		    // 根据主键从数据库查找对象
 			pubDictPo = pubDictMapper.findObjByPk(req.getDictItmId());
 			
 			// 如果未能查到对象, 运回错误信息
 			if (pubDictPo == null) {
 				res.setResCode(ResConstant.OPR_FAIL);
 				res.setResMsg("根据主键" + req.getDictItmId() + "找不到对象");
 				logger.error("根据主键{}找不到对象", req.getDictItmId());
 				return res;
 			}
 		}
		
 		pubDictPo.setDictNm(req.getDictNm()); // 字典名称
 		pubDictPo.setItmKey(req.getItmKey()); // 条目键
 		pubDictPo.setItmVal(req.getItmVal()); // 条目值
 		pubDictPo.setPara1(req.getPara1()); // 参数1
 		pubDictPo.setPara2(req.getPara2()); // 参数2
 		pubDictPo.setPara3(req.getPara3()); // 参数3
 		pubDictPo.setOdrNum(req.getOdrNum()); // 排序号
 		pubDictPo.setDltFlg(req.getDltFlg()); // 删除标识
 		pubDictPo.setCrtTm(req.getCrtTm()); // 创建时间
 		pubDictPo.setUdtTm(req.getUdtTm()); // 修改时间
 		pubDictPo.setRmk(req.getRmk()); // 备注
		
		if(isCreate){
		    pubDictMapper.insert(pubDictPo); // 执行插入
 			logger.info("添加成功, 返回主键: {}", pubDictPo.getDictItmId()); // 跟踪日志
		}
		else{
		    pubDictMapper.updateByPk(pubDictPo); // 执行修改
 			logger.info("修改数据");
		}
    
         // 设置响应结果码
         res.setResCode(ResConstant.OPR_SUCC);
    	 res.setResMsg("执行修改操作成功");
		 return res;
    }
    
    /**
	 * Description: 检查参数 <br/>
	 * Create info: Wanpeng.Hui, 2019/04/26  <br/>
	 *
	 * @return
	 */
	private void checkPara(CrtUptPubDictReq req, BaseRes res, boolean isCreate) {

		// 检查参数-主键, 修改时不能为空
        if(!isCreate && null == req.getDictItmId()){
            res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("字典条目ID必填");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-字典名称不能为空
        if(StringUtils.isEmpty(req.getDictNm())){
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("字典名称必填");
			logger.warn(res.getResMsg());
			return;
		}
	    // 检查参数-字典名称长度限制
	    if(req.getDictNm().length()>15){
	        res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("字典名称参数太长");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-条目键不能为空
        if(StringUtils.isEmpty(req.getItmKey())){
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("条目键必填");
			logger.warn(res.getResMsg());
			return;
		}
	    // 检查参数-条目键长度限制
	    if(req.getItmKey().length()>15){
	        res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("条目键参数太长");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-条目值不能为空
        if(StringUtils.isEmpty(req.getItmVal())){
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("条目值必填");
			logger.warn(res.getResMsg());
			return;
		}
	    // 检查参数-条目值长度限制
	    if(req.getItmVal().length()>15){
	        res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("条目值参数太长");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-排序号不能为空
		if(null == req.getOdrNum()){
            res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("排序号必填");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-删除标识不能为空
		if(null == req.getDltFlg()){
            res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("删除标识必填");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-创建时间不能为空
		if(null == req.getCrtTm()){
            res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("创建时间必填");
			logger.warn(res.getResMsg());
			return;
		}
		// 检查参数-修改时间不能为空
		if(null == req.getUdtTm()){
            res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("修改时间必填");
			logger.warn(res.getResMsg());
			return;
		}
	}
}
