package com.rt.modules.employee.dto.vo;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *  [employee] VO
 * Generate by Wanpeng.Hui's Dapeng-Generator 2019/04/23 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 */
public class EmployeeVo {
  
    // ------- 以下是通用字段 ---------------------------
    private Long id; // 员工id
	private String username; // 用户名
	private String password; // 用户名

	private String realname; // 真实姓名
	private String email; // 电子邮件
	private String mobile; 
	private Long age; // 年龄
	private Short sex; // 性别 1为男0为女
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date hiredate; // 入职时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date departuretime; // 离职时间
	private Short status; // 在职状态，默认1在职，0离职
	private Long departmentId; // 所属部门
	private Long employeeId; // 直属领导
	private String rmk; // 备注
	private String jobnumber; // 工号
	private Long salaryId; 
	private Short edubg; // 学历 1本科2大专3硕士4博士5大专以下
	private Short dltFlg; // 删除类型
	private String idcard; // 身份证号码
	private String salt; // 盐
  
    //-------- 以下是个性化字段 --------------------------
  
    /** 
     *Getter 员工id,主键,不能为空
     *@return
     */
    public Long getId(){
      return this.id;
    }
    
    /** 
     *Setter 员工id,主键,不能为空
     *@param id
     */
    public void setId(Long id){
      this.id = id;
    }
    /** 
     *Getter 用户名,不能为空
     *@return
     */
    public String getUsername(){
      return this.username;
    }
    
    /** 
     *Setter 用户名,不能为空
     *@param username
     */
    public void setUsername(String username){
      this.username = username;
    }
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    /** 
     *Getter 真实姓名,不能为空
     *@return
     */
    public String getRealname(){
      return this.realname;
    }
    
    /** 
     *Setter 真实姓名,不能为空
     *@param realname
     */
    public void setRealname(String realname){
      this.realname = realname;
    }
    /** 
     *Getter 电子邮件,不能为空
     *@return
     */
    public String getEmail(){
      return this.email;
    }
    
    /** 
     *Setter 电子邮件,不能为空
     *@param email
     */
    public void setEmail(String email){
      this.email = email;
    }
    /** 
     *Getter ,不能为空
     *@return
     */
    public String getMobile(){
      return this.mobile;
    }
    
    /** 
     *Setter ,不能为空
     *@param mobile
     */
    public void setMobile(String mobile){
      this.mobile = mobile;
    }
    /** 
     *Getter 年龄,不能为空
     *@return
     */
    public Long getAge(){
      return this.age;
    }
    
    /** 
     *Setter 年龄,不能为空
     *@param age
     */
    public void setAge(Long age){
      this.age = age;
    }
    /** 
     *Getter 性别 1为男0为女
     *@return
     */
    public Short getSex(){
      return this.sex;
    }
    
    /** 
     *Setter 性别 1为男0为女
     *@param sex
     */
    public void setSex(Short sex){
      this.sex = sex;
    }
    /** 
     *Getter 入职时间
     *@return
     */
    public Date getHiredate(){
      return this.hiredate;
    }
    
    /** 
     *Setter 入职时间
     *@param hiredate
     */
    public void setHiredate(Date hiredate){
      this.hiredate = hiredate;
    }
    /** 
     *Getter 离职时间
     *@return
     */
    public Date getDeparturetime(){
      return this.departuretime;
    }
    
    /** 
     *Setter 离职时间
     *@param departuretime
     */
    public void setDeparturetime(Date departuretime){
      this.departuretime = departuretime;
    }
    /** 
     *Getter 在职状态，默认1在职，0离职
     *@return
     */
    public Short getStatus(){
      return this.status;
    }
    
    /** 
     *Setter 在职状态，默认1在职，0离职
     *@param status
     */
    public void setStatus(Short status){
      this.status = status;
    }
    /** 
     *Getter 所属部门,不能为空
     *@return
     */
    public Long getDepartmentId(){
      return this.departmentId;
    }
    
    /** 
     *Setter 所属部门,不能为空
     *@param departmentId
     */
    public void setDepartmentId(Long departmentId){
      this.departmentId = departmentId;
    }
    /** 
     *Getter 直属领导,不能为空
     *@return
     */
    public Long getEmployeeId(){
      return this.employeeId;
    }
    
    /** 
     *Setter 直属领导,不能为空
     *@param employeeId
     */
    public void setEmployeeId(Long employeeId){
      this.employeeId = employeeId;
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
     *Getter 工号
     *@return
     */
    public String getJobnumber(){
      return this.jobnumber;
    }
    
    /** 
     *Setter 工号
     *@param jobnumber
     */
    public void setJobnumber(String jobnumber){
      this.jobnumber = jobnumber;
    }
    /** 
     *Getter ,不能为空
     *@return
     */
    public Long getSalaryId(){
      return this.salaryId;
    }
    
    /** 
     *Setter ,不能为空
     *@param salaryId
     */
    public void setSalaryId(Long salaryId){
      this.salaryId = salaryId;
    }
    /** 
     *Getter 学历 1本科2大专3硕士4博士5大专以下
     *@return
     */
    public Short getEdubg(){
      return this.edubg;
    }
    
    /** 
     *Setter 学历 1本科2大专3硕士4博士5大专以下
     *@param edubg
     */
    public void setEdubg(Short edubg){
      this.edubg = edubg;
    }
    /** 
     *Getter 删除类型
     *@return
     */
    public Short getDltFlg(){
      return this.dltFlg;
    }
    
    /** 
     *Setter 删除类型
     *@param dltflg
     */
    public void setDltFlg(Short dltFlg){
      this.dltFlg = dltFlg;
    }
    /** 
     *Getter 身份证号码,不能为空
     *@return
     */
    public String getIdcard(){
      return this.idcard;
    }
    
    /** 
     *Setter 身份证号码,不能为空
     *@param idcard
     */
    public void setIdcard(String idcard){
      this.idcard = idcard;
    }

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
    
    
}
