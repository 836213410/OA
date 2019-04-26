package com.rt.modules.department.dto.req;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.rt.global.dto.BaseReq;

/**
 * Description: 执行修改请求, 用户点提交时执行 <br/>
 *  [department] PO
 * Generate by Wanpeng.Hui's Dapeng-Generator <br/>
 * Create time 2019/04/26 13:07:42 
 */
public class CrtUptDepartmentReq extends BaseReq{
  
    private Long id; // 部门id,主键,不能为空
    private String deptName; // 部门名岑,不能为空
    private Long chiefId; // 部门总监
    private Long manageId; // 部门经理
    private Long totalNum; // 部门编制人数,不能为空
    private Long realNum; // 实际在职人数,不能为空
    private Short dltFlg; // 是否使用,不能为空
    private String rmk; // 备注
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")				
    private Date crtTm; // 创建时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")				
    private Date uptTm; // 更新时间
  
    /** 
     *Getter 部门id,主键,不能为空
     *@return
     */
    public Long getId(){
      return this.id;
    }
    
    /** 
     *Setter 部门id,主键,不能为空
     *@param id
     */
    public void setId(Long id){
      this.id = id;
    }
    
    /** 
     *Getter 部门名岑,不能为空
     *@return
     */
    public String getDeptName(){
      return this.deptName;
    }
    
    /** 
     *Setter 部门名岑,不能为空
     *@param deptName
     */
    public void setDeptName(String deptName){
      this.deptName = deptName;
    }
    
    /** 
     *Getter 部门总监
     *@return
     */
    public Long getChiefId(){
      return this.chiefId;
    }
    
    /** 
     *Setter 部门总监
     *@param chiefId
     */
    public void setChiefId(Long chiefId){
      this.chiefId = chiefId;
    }
    
    /** 
     *Getter 部门经理
     *@return
     */
    public Long getManageId(){
      return this.manageId;
    }
    
    /** 
     *Setter 部门经理
     *@param manageId
     */
    public void setManageId(Long manageId){
      this.manageId = manageId;
    }
    
    /** 
     *Getter 部门编制人数,不能为空
     *@return
     */
    public Long getTotalNum(){
      return this.totalNum;
    }
    
    /** 
     *Setter 部门编制人数,不能为空
     *@param totalNum
     */
    public void setTotalNum(Long totalNum){
      this.totalNum = totalNum;
    }
    
    /** 
     *Getter 实际在职人数,不能为空
     *@return
     */
    public Long getRealNum(){
      return this.realNum;
    }
    
    /** 
     *Setter 实际在职人数,不能为空
     *@param realNum
     */
    public void setRealNum(Long realNum){
      this.realNum = realNum;
    }
    
    /** 
     *Getter 是否使用,不能为空
     *@return
     */
    public Short getDltFlg(){
      return this.dltFlg;
    }
    
    /** 
     *Setter 是否使用,不能为空
     *@param dltFlg
     */
    public void setDltFlg(Short dltFlg){
      this.dltFlg = dltFlg;
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
    
    /** 
     *Getter 创建时间
     *@return
     */
    public Date getCrtTm(){
      return this.crtTm;
    }
    
    /** 
     *Setter 创建时间
     *@param crtTm
     */
    public void setCrtTm(Date crtTm){
      this.crtTm = crtTm;
    }
    
    /** 
     *Getter 更新时间
     *@return
     */
    public Date getUptTm(){
      return this.uptTm;
    }
    
    /** 
     *Setter 更新时间
     *@param uptTm
     */
    public void setUptTm(Date uptTm){
      this.uptTm = uptTm;
    }
    
}
