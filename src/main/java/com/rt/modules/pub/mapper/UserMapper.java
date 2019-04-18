package com.rt.modules.pub.mapper;

import java.util.List;

import com.rt.global.database.BaseMapper;
import com.rt.modules.pub.po.User;

public interface UserMapper extends BaseMapper<User,Long>{

	List<User> getAll();
}
