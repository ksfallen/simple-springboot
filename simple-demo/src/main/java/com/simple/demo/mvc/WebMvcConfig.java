package com.simple.demo.mvc;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

import static com.simple.config.web.HttpMessageConverterConfig.*;


/**
 * @author: Jianfeng.Hu
 * @date: 2017/9/30
 */
@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(stringHttpMessageConverter());
        converters.add(fastJsonHttpMessageConverter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        // registry.addInterceptor(new LoggerInterceptor());
        //.addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /**
     * 配置静态访问资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResoureHandler指的是对外暴露的访问路径
        // addResourceLocations指的是文件放置的目录
        // registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/");

        // 指定外部的目录
        // registry.addResourceHandler("/my/**").addResourceLocations("file:E:/my/");

        super.addResourceHandlers(registry);
    }

    /**
     * 页面跳转addViewControllers

     * 以前要访问一个页面需要先创建个Controller控制类，再写方法跳转到页面
     * 在这里配置后就不需要那么麻烦了，直接访问http://localhost:8080/toLogin就跳转到login.jsp页面了
     * @param registry
     */
    // @Override
    // public void addViewControllers(ViewControllerRegistry registry) {
    //     registry.addViewController("/toLogin").setViewName("login");
    //     super.addViewControllers(registry);
    // }
}
