package com.simple.gw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

// @EnableEurekaServer
@EnableZuulProxy
@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    /**
     * servicePattern 转 routePattern
     * 如 userservice-vl 转成 /vl/userservice/**
     *
     * @return
     */
    @Bean
    public PatternServiceRouteMapper routeMapper() {
        return new PatternServiceRouteMapper("(?<name> A .+)-(?<version>v.+$)", "${version}/${name}");
    }
}
