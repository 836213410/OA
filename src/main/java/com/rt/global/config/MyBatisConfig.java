package com.rt.global.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Description: mybatis配置<br/>
 * Create info: hongyang.zhao, 2019年4月16日 <br/>
 * Copyright (c) 2019, RunTong Information Technology Co.,Ltd. All Rights
 * Reserved. <br/>
 * 
 * @author hongyang.zhao
 * @Version 1.0
 */
@Configuration
@MapperScan("com.rt.modules.*.mapper")
public class MyBatisConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		System.out.println("123");
		System.out.println("2019-11-23-11-30");
		return new com.zaxxer.hikari.HikariDataSource();
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*/**.xml"));

		Properties properties = new Properties();
		properties.setProperty("dialect", "mysql");
		PagingInterceptor interceptor = new PagingInterceptor();
		interceptor.setProperties(properties);
		sqlSessionFactoryBean.setPlugins(new Interceptor[] { interceptor });

		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
