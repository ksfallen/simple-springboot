package com.simple.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.business.api.HelloBusinessService;
import com.simple.entity.dto.UserDTO;

/**
 * @author: Jfeng
 * @date: 2017/7/14
 */
@RestController
// @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HelloController {

    @Autowired
    private HelloBusinessService helloService;


    @RequestMapping("/hello")
    public String hello() {
        return helloService.hello();
    }

    @RequestMapping("/hello2")
    public String hello(String name) {
        return helloService.hello(name);
    }

    @RequestMapping("/hello3")
    public String hello(Integer age, String name) {
        return helloService.hello(age, name);
    }

    @RequestMapping("/hello4")
    public String hello(@RequestBody UserDTO userDTO) {
        return helloService.hello(userDTO);
    }


}
