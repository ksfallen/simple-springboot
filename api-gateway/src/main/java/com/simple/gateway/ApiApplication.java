package com.simple.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simple.gateway.config.RibbonConfiguration;

// @EnableEurekaServer
@EnableZuulProxy
@SpringCloudApplication
@EnableHystrixDashboard
// @RibbonClients(defaultConfiguration = {RibbonConfiguration.class})
@RestController
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
