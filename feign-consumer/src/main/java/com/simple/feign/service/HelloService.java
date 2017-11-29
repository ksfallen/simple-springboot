package com.simple.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.simple.business.api.HelloBusinessService;
import com.simple.constants.ServiceConstants;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/24
 */
@FeignClient(value = ServiceConstants.HELLO_SERVICE_NAME)
public interface HelloService extends HelloBusinessService {

    // @RequestMapping("/hello")
    // String hello();
    //
    // @RequestMapping("/hello2")
    // String hello(@RequestParam("name") String name);
    //
    // @RequestMapping("/hello3")
    // String hello(@RequestParam("age") Integer age, @RequestParam("name") String name);
    //
    // @RequestMapping("/hello4")
    // String hello(@RequestBody UserDTO userDTO);



}
