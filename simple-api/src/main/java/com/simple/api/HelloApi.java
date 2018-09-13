package com.simple.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.constants.SimpleServiceConstants;

/**
 * @author: Jfeng
 * @date: 2018/5/18
 */
@FeignClient(value = SimpleServiceConstants.SIMPLE_SERVICE_NAME)
public interface HelloApi {

    @RequestMapping("/hello")
    String hello() throws Exception;
}
