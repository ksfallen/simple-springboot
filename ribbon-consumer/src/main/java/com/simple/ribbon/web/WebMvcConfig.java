package com.simple.ribbon.web;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

import static com.simple.config.web.HttpMessageConverterConfig.fastJsonHttpMessageConverter;
import static com.simple.config.web.HttpMessageConverterConfig.stringHttpMessageConverter;


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

}
