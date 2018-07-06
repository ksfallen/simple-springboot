package com.simple.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * User: Jfeng
 * Date:  2017/6/23
 */
@Configuration
@ConditionalOnClass(DruidDataSource.class)
@PropertySource(value = {"classpath:druid.properties"}, ignoreResourceNotFound = true)
public class DataSourceConfig {

    // application >  druid > config/druid
    // config/application > classpath:application
    @Bean
    public DataSource createDataSource(Environment env) {
        DruidDataSource build = DruidDataSourceBuilder.create().build();
        return build;
    }
}
