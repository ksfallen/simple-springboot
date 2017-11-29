package com.simple.config.client;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.config.client.config.SpaceConfig;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ConfigClientApplication {

    @Resource
    private SpaceConfig spaceConfig;

    @RequestMapping("/")
    public String index() {
        return spaceConfig.getFrom();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
