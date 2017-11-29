package com.simple.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.entity.dto.UserDTO;
import com.simple.feign.service.HelloService;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/24
 */
@RestController
public class ConsumerController {
    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello")
    public String hello() {
        return "feign consumer: " + helloService.hello();
    }

    @RequestMapping(value = "/hello2")
    public String hello1() {

        StringBuilder sb = new StringBuilder();

        sb.append(helloService.hello("Tom")).append("\n");
        sb.append(helloService.hello(10, "Tom")).append("\n");
        sb.append(helloService.hello(new UserDTO(11, "ABC")));

        return sb.toString();
    }

}
