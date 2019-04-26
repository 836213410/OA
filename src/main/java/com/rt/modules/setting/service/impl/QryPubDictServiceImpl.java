package com.rt.modules.setting.service.impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rt.global.constant.ResConstant;
import com.rt.global.dto.QryObjRes;
import com.rt.global.dto.QryPgBaseRes;
import com.rt.modules.setting.dto.req.QryDictKeyReq;
import com.rt.modules.setting.dto.req.QryPgPubDictReq;
import com.rt.modules.setting.dto.res.QryDictKeyRes;
import com.rt.modules.setting.dto.vo.PubDictVo;
import com.rt.modules.setting.mapper.PubDictMapper;
import com.rt.modules.setting.po.PubDictPo;
import com.rt.modules.setting.service.QryPubDictService;

/** 
 *Description: 系统字典表[pub_dict]管理接口实现类 <br/>
 *Generate by Wanpeng.Hui's Pengpeng-Generator 2019/04/26 <br/>
 *Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 *
 *@Version 1.0
 */
 @Service
public class QryPubDictServiceImpl implements QryPubDictService{
	
	@Autowired
	private PubDictMapper pubDictMapper; // 系统字典表Mapper
	private static Logger logger = LoggerFactory.getLogger(QryPubDictServiceImpl.class); // 记录日志
	
	@Override
    @Transactional(readOnly = true)
	public QryObjRes<PubDictVo> getPubDictVoById(Long id){
	    QryObjRes<PubDictVo> res = new QryObjRes<PubDictVo>();
		
		PubDictPo po = pubDictMapper.findObjByPk(id); // 从数据库查询
		if(null == po) {
			res.setResCode(ResConstant.OPR_FAIL_PARAMETER);
			res.setResMsg("未找到对象, 请检查参数是否正确");
			logger.info("根据ID{}未找到对象", id);
			return res;
		}
		
	    PubDictVo pubDictVo = new PubDictVo();
		pubDictVo.setDictItmId(po.getDictItmId()); // 字典条目ID
		pubDictVo.setDictNm(po.getDictNm()); // 字典名称
		pubDictVo.setItmKey(po.getItmKey()); // 条目键
		pubDictVo.setItmVal(po.getItmVal()); // 条目值
		pubDictVo.setPara1(po.getPara1()); // 参数1
		pubDictVo.setPara2(po.getPara2()); // 参数2
		pubDictVo.setPara3(po.getPara3()); // 参数3
		pubDictVo.setOdrNum(po.getOdrNum()); // 排序号
		pubDictVo.setDltFlg(po.getDltFlg()); // 删除标识
		pubDictVo.setCrtTm(po.getCrtTm()); // 创建时间
		pubDictVo.setUdtTm(po.getUdtTm()); // 修改时间
		pubDictVo.setRmk(po.getRmk()); // 备注
		
		res.setObj(pubDictVo); // 设置对象
		res.setResCode(ResConstant.OPR_SUCC_QUIET);
		res.setResMsg("查找根据ID查找对象成功");
		logger.info("查找根据ID{}查找对象成功", id);
		return res;
	}

    @Override
    @Transactional(readOnly = true)
    public QryPgBaseRes<PubDictVo> qryPgPubDict(QryPgPubDictReq req){
        QryPgBaseRes<PubDictVo> res = new QryPgBaseRes<PubDictVo>();
      
        // 记录传入参数, 以方便调试
	
        HashMap<String, Object> conditionMap = new HashMap<String, Object>();
  
		int total = pubDictMapper.queryCountByMap(conditionMap); // 统计条数
		if (total > 0) {
			// 从数据库查询
			List<PubDictPo> pubDictPoLst = pubDictMapper.queryPageByMap(conditionMap,
					new RowBounds(req.getOffset(), req.getLimit()));

			List<PubDictVo> pubDictVoLst = new ArrayList<PubDictVo>();
			PubDictVo pubDictVo = null;
			for (PubDictPo po : pubDictPoLst) {
				pubDictVo = new PubDictVo();
				
				// 从PO向VO设值
				pubDictVo.setDictItmId(po.getDictItmId()); // 字典条目ID
				pubDictVo.setDictNm(po.getDictNm()); // 字典名称
				pubDictVo.setItmKey(po.getItmKey()); // 条目键
				pubDictVo.setItmVal(po.getItmVal()); // 条目值
				pubDictVo.setPara1(po.getPara1()); // 参数1
				pubDictVo.setPara2(po.getPara2()); // 参数2
				pubDictVo.setPara3(po.getPara3()); // 参数3
				pubDictVo.setOdrNum(po.getOdrNum()); // 排序号
				pubDictVo.setDltFlg(po.getDltFlg()); // 删除标识
				pubDictVo.setCrtTm(po.getCrtTm()); // 创建时间
				pubDictVo.setUdtTm(po.getUdtTm()); // 修改时间
				pubDictVo.setRmk(po.getRmk()); // 备注
				
				pubDictVoLst.add(pubDictVo); // 加入集合
			}
			res.setCount(total); //设置统计条数
			res.setData(pubDictVoLst); // 设置VO集合
		}
		
		res.setResCode(ResConstant.OPR_SUCC_QUIET);
		res.setResMsg("执行查询操作成功");
		logger.info("查询操作成功");
		return res;
    } 
    
    
	/**
	 * Description:  字典数据项值翻译服务接口 <br/>
	 * Create info: Wanpeng.Hui, 2018/04/09 <br/>
	 *
	 * @param req 传入字典名称(dictNm)和条目值(dictVal)
	 * @return res 返回条目键(dictKey)
	 */
	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "pubDictItmKeyCache", key = "'getDictItmKey'+#req.dictNm+#req.itmVal")
	public QryDictKeyRes getDictItmKey(QryDictKeyReq req) {
		
		QryDictKeyRes res = new QryDictKeyRes();
		logger.info("进入字典数据项值翻译方法, {}, {}", req.getDictNm(), req.getItmVal());
		if (StringUtils.isNotBlank(req.getDictNm()) && StringUtils.isNotBlank(req.getItmVal())) {
			//如果传入的DictNm和DictVal不为空，进入查询
			String dictItmKey = pubDictMapper.getDictItmKey(req.getDictNm(), req.getItmVal());
			logger.info("dictItmKey------------------------------"+dictItmKey);
			if (StringUtils.isNotBlank(dictItmKey)) {
				res.setItmKey(dictItmKey);
				res.setResCode(ResConstant.OPR_SUCC);
				res.setResMsg("根据字典名称和字典值查询成功");
				logger.info("根据字典名称和字典值查询成功");
			}else {
				res.setResCode(ResConstant.OPR_SUCC);
				res.setResMsg("根据字典名称和字典值未查询出对应字典条目");
				logger.info("根据字典名称和字典值未查询出对应字典条目");
			}
			
		}else{
			res.setResCode(ResConstant.OPR_FAIL);
			res.setResMsg("参数传入异常");
			logger.info("参数传入异常,请检查dictNm,{},dictVal,{}",req.getDictNm(),req.getItmVal());
		}
		
		
		return res;
	}
}
