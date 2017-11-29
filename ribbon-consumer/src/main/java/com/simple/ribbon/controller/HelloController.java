package com.simple.ribbon.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.ribbon.service.AppInfoService;

/**
 * @author: Jfeng
 * @date: 2017/7/14
 */
@RestController
public class HelloController {

    @Autowired
    private AppInfoService appInfoService;

    @RequestMapping("/hello")
    public String hello() throws ExecutionException, InterruptedException {
        return appInfoService.hello2();
    }
}
