package com.simple.feign.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.simple.feign.service.HelloServiceFallback;

import feign.Feign;
import feign.hystrix.HystrixFeign;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/25
 */
@Configuration
public class SimpleHystrixConfiguration {
    //
    // @Bean
    // @Scope("prototype")
    // public Feign.Builder feignBuilder() {
    //     return Feign.builder();
    // }

    @Bean
    @Scope("prototype")
    public Feign.Builder feignHystrixBuilder() {
        return HystrixFeign.builder();
    }

    @Bean
    public HelloServiceFallback fb() {
        return new HelloServiceFallback();
    }
}
