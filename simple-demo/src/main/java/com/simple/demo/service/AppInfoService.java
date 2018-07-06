package com.simple.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.simple.api.AppInfoApi;
import com.simple.common.base.bean.ResultBean;
import com.simple.common.base.bean.ResultBeanBuilder;
import com.simple.constants.ServiceConstants;
import com.simple.entity.dto.AppInfoDTO;

import static com.simple.common.base.bean.ResultBeanBuilder.success;

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
        return appInfoApi.getAppInfo(appInfoId);
    }

    // public ResultBean<AppInfoDTO> getAppInfoFallback(Integer appInfoId) {
    //     AppInfoDTO bean = new AppInfoDTO();
    //     bean.setAppInfoId(appInfoId);
    //     return ResultBeanBuilder.success().withData(bean).build();
    // }
}
