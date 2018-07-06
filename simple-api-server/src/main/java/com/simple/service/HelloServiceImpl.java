package com.simple.service;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.simple.api.HelloApi;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Jfeng
 * @date: 2018/5/18
 */
@RestController
@Slf4j
public class HelloServiceImpl implements HelloApi {

    @Override
    public String hello() throws Exception {
        // 测试超时
        int sleepTime = new Random().nextInt(8000);
        log.info("/hello sleep time{}", sleepTime);
        Thread.sleep(sleepTime);

        return "Hello World";
    }

}
