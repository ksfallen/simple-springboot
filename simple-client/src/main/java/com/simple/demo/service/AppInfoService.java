package com.simple.demo.service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.simple.api.AppInfoApi;
import com.simple.common.base.bean.ResultBean;
import com.simple.common.base.bean.ResultBeanBuilder;
import com.simple.entity.dto.AppInfoDTO;

/**
 * @author: Jfeng
 * @date: 2018/5/17
 */
@Service
public class AppInfoService {

    @Autowired
    private AppInfoApi appInfoApi;

    // @HystrixCommand(fallbackMethod = "getAppInfoFallback")
    public ResultBean<AppInfoDTO> getAppInfo(Integer appInfoId) {
        Object info1 = appInfoApi.getAppInfo(appInfoId);
        ResultBean<AppInfoDTO> info = appInfoApi.getAppInfo(appInfoId);
        return info;
    }

    // public ResultBean<AppInfoDTO> getAppInfoFallback(Integer appInfoId) {
    //     AppInfoDTO bean = new AppInfoDTO();
    //     bean.setAppInfoId(appInfoId);
    //     return ResultBeanBuilder.success().withData(bean).build();
    // }

    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String hello2() {
        try {
            // 测试断路,  hystrix 默认是2秒
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // String object = RestTemplateUtil.getForObject(ServiceConstants.hello);
        return null;
    }

    /**
     * 异步请求
     * @return
     */
    @HystrixCommand
    public Future<String> hello() {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return null;
                // return RestTemplateUtil.getForObject(ServiceConstants.hello);
            }
        };
    }

    private String helloFallBack() {
        return ResultBeanBuilder.error().withMessage("helloFallBack desc").build().toString();
    }
}
