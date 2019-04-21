package com.rt.modules.pub.dto.req;

import com.rt.global.dto.BaseReq;

/**
 * Description: 执行修改请求, 用户点提交时执行 <br/>
 *  [user] PO
 * Generate by Wanpeng.Hui's Dapeng-Generator <br/>
 * Create time 2019/04/21 21:46:14 
 */
public class CrtUptUserReq extends BaseReq{
  
    private Long id; 
    private String name; 
  
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
