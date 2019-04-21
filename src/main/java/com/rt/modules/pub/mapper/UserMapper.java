package com.rt.modules.pub.mapper;

import org.springframework.stereotype.Repository;

import com.rt.global.database.BaseMapper;
import com.rt.modules.pub.po.UserPo;

@Repository
public interface UserMapper extends BaseMapper<UserPo,Long>{

}
