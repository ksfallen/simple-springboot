package com.simple.ribbon.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.simple.common.util.RestTemplateUtil;
import com.simple.constants.ServiceConstants;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/24
 */
public class HelloCommand  extends HystrixCommand<String>{

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
