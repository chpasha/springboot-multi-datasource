package com.example.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


/**
 * User: pavel
 * Date: 14.09.21
 * Time: 20:19
 */
@Configuration
public class MyConfig
{
	@Primary
	@Bean
	@ConfigurationProperties(prefix = "app.datasource1")
	public DataSource dataSource1()
	{
		return DataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties(prefix = "app.datasource2")
	public DataSource dataSource2()
	{
		return DataSourceBuilder.create().build();
	}

	@Bean
	public JdbcTemplate jdbcTemplate1()
	{
		DataSource ds = dataSource1();
		return new JdbcTemplate(ds);
	}

	@Bean
	public JdbcTemplate jdbcTemplate2()
	{
		DataSource ds = dataSource2();
		return new JdbcTemplate(ds);
	}
}
