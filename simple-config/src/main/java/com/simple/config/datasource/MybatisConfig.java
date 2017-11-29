package com.simple.config.datasource;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/4
 */
// @Configuration
// @ConditionalOnClass({MapperScannerConfigurer.class})
// @PropertySource(value = {"classpath:mybatis.properties"}, ignoreResourceNotFound = true)
public class MybatisConfig {

    //
    // @Bean
    // public MapperScannerConfigurer mapperScannerConfigurer() {
    //     MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    //     // mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
    //     mapperScannerConfigurer.setBasePackage("com.simple.demo.mapper");
    //     mapperScannerConfigurer.setMarkerInterface(BaseCommonMapper.class);
    //
    //     Properties properties = new Properties();
    //     // 不要把 BaseCommonMapper 放到 basePackage 中，不能同其他Mapper一样被扫描到。
    //     // properties.setProperty("mappers", BaseCommonMapper.class.getName());
    //     properties.setProperty("IDENTITY", "MYSQL");
    //     properties.setProperty("style", "normal");
    //     mapperScannerConfigurer.setProperties(properties);
    //     return mapperScannerConfigurer;
    // }

    /**
     * 分页插件
     *
     * @param dataSource
     * @return
     * @author SHANHY
     * @create  2016年2月18日
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
