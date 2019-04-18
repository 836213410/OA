package com.rt.global.database;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

public interface BaseMapper<T, I>{

	/**
	 * 新增加记录
	 * 
	 * @param t
	 * @return
	 */
	int insert(T t);

	/**
	 * 以实体对象的主键作为条件,修改记录
	 * 
	 * @param t
	 * @return
	 */
	int updateByPk(T t);

	/**
	 * 以HashMap作为条件参数,修改记录
	 * 
	 * @param hashMap
	 * @return
	 */
	int updateByHashMap(HashMap<String, Object> hashMap);

	/**
	 * 仅以主键作为条件,删除记录
	 * 
	 * @param t
	 * @return
	 */
	int deleteByPk(I i);

	/**
	 * 以实体对象作为条件参数,删除记录
	 * 
	 * @param t
	 * @return
	 */
	int deleteByObj(T t);

	/**
	 * 以实体对象作为条件参数,查找记录,返回对象
	 * 
	 * @param pk
	 * @return
	 */
	T findObjByPk(I i);

	/**
	 * 以实体对象作为条件参数,查找记录,返回对象集合
	 * 
	 * @param t
	 * @return
	 */
	List<T> queryLstByObj(T t);

	/**
	 * 以实体对象作为条件参数,查找记录,返回对象集合
	 * 
	 * @param t
	 * @return
	 */
	List<T> queryPageByObj(T t, RowBounds rowBounds);

	/**
	 * 以实体对象作为条件参数,查询记录数
	 * 
	 * @param t
	 * @return
	 */
	int queryCountByObj(T t);

	/**
	 * 根据HashMap作为条件参数,查找记录,返回对象集合
	 * 
	 * @param hashMap
	 * @param rowBounds
	 */
	List<T> queryPageByMap(HashMap<String, Object> hashMap, RowBounds rowBounds);

	/**
	 * 查询记录条数
	 * 
	 * @param hashMap
	 */
	int queryCountByMap(HashMap<String, Object> hashMap);
}
