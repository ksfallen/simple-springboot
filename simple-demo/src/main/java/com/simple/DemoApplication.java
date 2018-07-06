package com.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.simple.constants.ServiceConstants;

import feign.Logger;

// @EnableDiscoveryClient
// @SpringBootApplication
// @EnableCircuitBreaker // 开启断路器
@SpringCloudApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableFeignClients(basePackages = ServiceConstants.SIMPLE_SERVICE_API_PAGENAME)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }

}
