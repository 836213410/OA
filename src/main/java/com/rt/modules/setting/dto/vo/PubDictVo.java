package com.rt.modules.setting.dto.vo;



import java.util.Date;

/**
 * 系统字典表 [pub_dict] VO
 * Generate by Wanpeng.Hui's Dapeng-Generator 2019/04/26 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 */
public class PubDictVo {
  
    // ------- 以下是通用字段 ---------------------------
	
    private Long dictItmId; // 字典条目ID
	private String dictNm; // 字典名称
	private String itmKey; // 条目键
	private String itmVal; // 条目值
	private String para1; // 参数1
	private String para2; // 参数2
	private String para3; // 参数3
	private Long odrNum; // 排序号
	private Long dltFlg; // 删除标识
	private Date crtTm; // 创建时间
	private Date udtTm; // 修改时间
	private String rmk; // 备注
  
    //-------- 以下是个性化字段 --------------------------
  
    /** 
     *Getter 字典条目ID,主键,不能为空
     *@return
     */
    public Long getDictItmId(){
      return this.dictItmId;
    }
    
    /** 
     *Setter 字典条目ID,主键,不能为空
     *@param dictItmId
     */
    public void setDictItmId(Long dictItmId){
      this.dictItmId = dictItmId;
    }
    /** 
     *Getter 字典名称,不能为空
     *@return
     */
    public String getDictNm(){
      return this.dictNm;
    }
    
    /** 
     *Setter 字典名称,不能为空
     *@param dictNm
     */
    public void setDictNm(String dictNm){
      this.dictNm = dictNm;
    }
    /** 
     *Getter 条目键,不能为空
     *@return
     */
    public String getItmKey(){
      return this.itmKey;
    }
    
    /** 
     *Setter 条目键,不能为空
     *@param itmKey
     */
    public void setItmKey(String itmKey){
      this.itmKey = itmKey;
    }
    /** 
     *Getter 条目值,不能为空
     *@return
     */
    public String getItmVal(){
      return this.itmVal;
    }
    
    /** 
     *Setter 条目值,不能为空
     *@param itmVal
     */
    public void setItmVal(String itmVal){
      this.itmVal = itmVal;
    }
    /** 
     *Getter 参数1
     *@return
     */
    public String getPara1(){
      return this.para1;
    }
    
    /** 
     *Setter 参数1
     *@param para1
     */
    public void setPara1(String para1){
      this.para1 = para1;
    }
    /** 
     *Getter 参数2
     *@return
     */
    public String getPara2(){
      return this.para2;
    }
    
    /** 
     *Setter 参数2
     *@param para2
     */
    public void setPara2(String para2){
      this.para2 = para2;
    }
    /** 
     *Getter 参数3
     *@return
     */
    public String getPara3(){
      return this.para3;
    }
    
    /** 
     *Setter 参数3
     *@param para3
     */
    public void setPara3(String para3){
      this.para3 = para3;
    }
    /** 
     *Getter 排序号,不能为空
     *@return
     */
    public Long getOdrNum(){
      return this.odrNum;
    }
    
    /** 
     *Setter 排序号,不能为空
     *@param odrNum
     */
    public void setOdrNum(Long odrNum){
      this.odrNum = odrNum;
    }
    /** 
     *Getter 删除标识,不能为空
     *@return
     */
    public Long getDltFlg(){
      return this.dltFlg;
    }
    
    /** 
     *Setter 删除标识,不能为空
     *@param dltFlg
     */
    public void setDltFlg(Long dltFlg){
      this.dltFlg = dltFlg;
    }
    /** 
     *Getter 创建时间,不能为空
     *@return
     */
    public Date getCrtTm(){
      return this.crtTm;
    }
    
    /** 
     *Setter 创建时间,不能为空
     *@param crtTm
     */
    public void setCrtTm(Date crtTm){
      this.crtTm = crtTm;
    }
    /** 
     *Getter 修改时间,不能为空
     *@return
     */
    public Date getUdtTm(){
      return this.udtTm;
    }
    
    /** 
     *Setter 修改时间,不能为空
     *@param udtTm
     */
    public void setUdtTm(Date udtTm){
      this.udtTm = udtTm;
    }
    /** 
     *Getter 备注
     *@return
     */
    public String getRmk(){
      return this.rmk;
    }
    
    /** 
     *Setter 备注
     *@param rmk
     */
    public void setRmk(String rmk){
      this.rmk = rmk;
    }
}
