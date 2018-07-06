package com.simple.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.constants.ServiceConstants;

/**
 * @author: Jfeng
 * @date: 2018/5/18
 */
@FeignClient(value = ServiceConstants.SIMPLE_SERVICE_NAME)
public interface HelloApi {

    @RequestMapping("/hello")
    String hello() throws Exception;
}
