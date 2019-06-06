package com.simple.demo.service;

import org.aspectj.lang.annotation.Aspect;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.simple.api.AppInfoApi;
import com.simple.common.base.bean.ResultBean;
import com.simple.common.base.bean.ResultBeanBuilder;
import com.simple.entity.dto.AppInfoDTO;

/**
 * @author: Jfeng
 * @date: 2018/5/17
 */
public class AppInfoServiceFallBack implements AppInfoApi {

    @Override
    public ResultBean<AppInfoDTO> getAppInfo(Integer appInfoId) {
        AppInfoDTO bean = new AppInfoDTO();
        bean.setAppInfoId(appInfoId);
        return ResultBeanBuilder.success().withData(bean).build();
    }

}
