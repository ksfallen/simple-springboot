package com.simple.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

/**
 * User: Jfeng
 * Date:  2017/6/23
 */
// @Configuration
public class DataSourceConfig {

    // application >  druid > config/druid
    // config/application > classpath:application
    // @Bean
    // public DataSource createDataSource(Environment env) {
    //     DataSource dataSource = new HikariDataSource();
    //     // DruidDataSource build = DruidDataSourceBuilder.builder().build();
    //     return dataSource;
    // }
}
