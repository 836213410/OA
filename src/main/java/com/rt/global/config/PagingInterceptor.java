package com.rt.global.config;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.RowBounds;

/**
 * Description: mysql分页拦截器 <br/>
 * Create info: wanpeng.hui, 2017/04/11 <br/>
 * Copyright (c) 2018, Hema Information Technology Co.,Ltd. All Rights Reserved.
 *
 * @Version 1.0
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class PagingInterceptor implements Interceptor {
	private static final Log logger = LogFactory.getLog(PagingInterceptor.class);

	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();

	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

	private static final ReflectorFactory DEFAULT_REFLECTOR_FACTORY = new DefaultReflectorFactory();

	private static final String DEFAULT_DIALECT = "mysql";

	private static String dialect = "";

	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY, DEFAULT_REFLECTOR_FACTORY);
		RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");

		// if the rowbounds is not initialized
		if (rowBounds == null || (rowBounds.getOffset() == 0 && rowBounds.getLimit() == Integer.MAX_VALUE)) {
			logger.debug("the rowbounds is not initialized");
			return invocation.proceed();
		}

		if (rowBounds == null || (rowBounds.getOffset() == 0 && rowBounds.getLimit() == 0)) {
			logger.debug("the rowbounds is not initialized");
			return invocation.proceed();
		}

		// get target of proxy object
		while (metaStatementHandler.hasGetter("h")) {
			Object object = metaStatementHandler.getValue("h");
			metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY, DEFAULT_REFLECTOR_FACTORY);
		}

		// get target of proxy object
		while (metaStatementHandler.hasGetter("target")) {
			Object object = metaStatementHandler.getValue("target");
			metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY, DEFAULT_REFLECTOR_FACTORY);
		}

		// build sql
		BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
		String sql = boundSql.getSql();
		String pageSql = buildPageSql(sql, rowBounds);
		logger.debug("the paging sql: " + pageSql);

		// set metaStatementHandler value
		metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
		metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
		metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);

		return invocation.proceed();
	}

	/**
	 * <ul>
	 * <li>Description:[build page sql by database dialect]</li>
	 * <li>Created by [wanpeng.hui] [2015/12/26]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * </ul>
	 * 
	 * @param sql
	 * @param rowBounds
	 * @return
	 */
	private String buildPageSql(String sql, RowBounds rowBounds) {
		// build mysql database paging sql
		if ("mysql".equalsIgnoreCase(dialect)) {
			return buildPageSqlForMysql(sql, rowBounds).toString();
		}

		// build oracle database paging sql
		if ("oracle".equalsIgnoreCase(dialect)) {
			return buildPageSqlForOracle(sql, rowBounds).toString();
		}

		return sql;
	}

	/**
	 * <ul>
	 * <li>Description:[build page sql for mysql]</li>
	 * <li>Created by [wanpeng.hui] [2015/12/26]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * </ul>
	 * 
	 * @param sql
	 * @param rowBounds
	 * @return
	 */
	private String buildPageSqlForMysql(String sql, RowBounds rowBounds) {
		StringBuilder pageSql = new StringBuilder(100);
		pageSql.append(sql);
		pageSql.append(" limit " + rowBounds.getOffset() + "," + rowBounds.getLimit());

		return pageSql.toString();
	}

	/**
	 * <ul>
	 * <li>Description:[build page sql for oracle ]</li>
	 * <li>Created by [wanpeng.hui] [2015/12/26]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * </ul>
	 * 
	 * @param sql
	 * @param rowBounds
	 * @return
	 */
	private String buildPageSqlForOracle(String sql, RowBounds rowBounds) {
		int beginRow = (rowBounds.getOffset() < 1) ? 1 : rowBounds.getOffset();
		int endRow = rowBounds.getOffset() + rowBounds.getLimit();

		StringBuilder pageSql = new StringBuilder(100);
		pageSql.append("select * from ( select t.*, rownum rn from ( ");
		pageSql.append(sql);
		pageSql.append(" ) t where rownum <= ").append(endRow);
		pageSql.append(") where rn > ").append(beginRow);

		return pageSql.toString();
	}

	public Object plugin(Object target) {
		// when target is type of StatementHandler, wrap it
		if (target instanceof StatementHandler) {
			return Plugin.wrap(target, this);
		}

		return target;
	}

	public void setProperties(Properties properties) {
		// set dialect from plug properties
		dialect = properties.getProperty("dialect");
		if (null == dialect || "".equals(dialect)) {
			logger.warn("Property dialect is not setted, will use default 'mysql' ");
			dialect = DEFAULT_DIALECT;
		}
	}

}
