package com.simple.demo.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/24
 */
public class HelloCommand extends HystrixCommand<String>{

    protected HelloCommand(HystrixCommandGroupKey group) {
        super(group);
    }

    @Override
    protected String run() throws Exception {
        return null;
    }

    @Override
    protected String getFallback() {
        return "fallback";
    }
}
