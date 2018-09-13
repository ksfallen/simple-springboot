package com.simple.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.common.base.bean.ResultBean;
import com.simple.constants.SimpleServiceConstants;
import com.simple.entity.dto.AppInfoDTO;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/17
 */
@FeignClient(value = SimpleServiceConstants.SIMPLE_SERVICE_NAME)
public interface AppInfoApi {

    @RequestMapping(value = "/appinfo/{appInfoId}")
    ResultBean<AppInfoDTO> getAppInfo(@PathVariable("appInfoId") Integer appInfoId);
}
