package com.simple.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.simple.common.base.bean.ResultBean;
import com.simple.constants.ServiceConstants;
import com.simple.entity.dto.AppInfoDTO;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/17
 */
@FeignClient(value = ServiceConstants.SIMPLE_SERVICE_NAME)
public interface AppInfoApi {

    @RequestMapping(value = "/appinfo/{appInfoId}")
    ResultBean<AppInfoDTO> getAppInfo(@PathVariable("appInfoId") Integer appInfoId);
}
