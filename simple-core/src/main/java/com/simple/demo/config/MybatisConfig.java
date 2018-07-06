package com.simple.demo.config;

import java.util.Properties;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.simple.common.base.BaseMapper;

import tk.mybatis.spring.annotation.MapperScan;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/4
 */
@Configuration
@ConditionalOnClass({SqlSessionFactory.class, SqlSessionFactoryBean.class})
@PropertySource(value = {"classpath:config/mybatis.properties"}, ignoreResourceNotFound = true)
@MapperScan(value = "com.simple.demo.mapper")
public class MybatisConfig {

    @Autowired
    private SqlSessionFactory factory;

    // 使用 mybatis.properties 的 配置文件代替
    // @Bean
    // public MapperScannerConfigurer mapperScannerConfigurer() {
    //     MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    //     mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
    //     mapperScannerConfigurer.setBasePackage("com.simple.demo.mapper");
    //
    //     // 只注册 basePackage 下继承BaseMapper接口的 Mapper 类
    //     mapperScannerConfigurer.setMarkerInterface(BaseMapper.class);
    //
    //     Properties properties = new Properties();
    //     // 不要把 BaseCommonMapper 放到 basePackage 中，不能同其他Mapper一样被扫描到。
    //     properties.setProperty("mappers", BaseMapper.class.getName());
    //     properties.setProperty("IDENTITY", "MYSQL");
    //     properties.setProperty("style", "normal");
    //
    //     mapperScannerConfigurer.setProperties(properties);
    //     return mapperScannerConfigurer;
    // }

    /**
     * 分页插件
     */
    // @Bean
    // public PageHelper pageHelper(DataSource dataSource) {
    //     log.info("注册MyBatis分页插件PageHelper");
    //     PageHelper pageHelper = new PageHelper();
    //     Properties p = new Properties();
    //     p.setProperty("offsetAsPageNum", "true");
    //     p.setProperty("rowBoundsWithCount", "true");
    //     p.setProperty("reasonable", "true");
    //     pageHelper.setProperties(p);
    //     return pageHelper;
    // }
}
