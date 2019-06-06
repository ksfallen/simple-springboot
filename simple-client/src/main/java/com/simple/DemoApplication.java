package com.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.simple.constants.SimpleServiceConstants;

import feign.Logger;

@SpringCloudApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableFeignClients(basePackages = SimpleServiceConstants.SIMPLE_SERVICE_API_PAGENAME)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }

}
