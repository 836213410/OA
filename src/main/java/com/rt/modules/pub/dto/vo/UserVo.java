package com.rt.modules.pub.dto.vo;

/**
 *  [user] VO
 * Generate by Wanpeng.Hui's Dapeng-Generator 2019/04/21 <br/>
 * Copyright (c) 2019, hwpok@163.com All Rights Reserved. <br/>
 */
public class UserVo {
  
    // ------- 以下是通用字段 ---------------------------
    private Long id; 
	private String name; 
  
    //-------- 以下是个性化字段 --------------------------
  
    /** 
     *Getter ,主键,不能为空
     *@return
     */
    public Long getId(){
      return this.id;
    }
    
    /** 
     *Setter ,主键,不能为空
     *@param id
     */
    public void setId(Long id){
      this.id = id;
    }
    /** 
     *Getter 
     *@return
     */
    public String getName(){
      return this.name;
    }
    
    /** 
     *Setter 
     *@param name
     */
    public void setName(String name){
      this.name = name;
    }
}
