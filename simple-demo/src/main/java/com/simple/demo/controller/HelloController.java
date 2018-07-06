package com.simple.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.api.HelloApi;
import com.simple.entity.dto.UserDTO;

/**
 * @author: Jfeng
 * @date: 2017/7/14
 */
@RestController
public class HelloController {

    @Autowired
    private HelloApi helloApi;


    @RequestMapping("/hello")
    public String hello() throws Exception {
        return helloApi.hello();
    }

    //
    // @RequestMapping("/hello2")
    // public String hello(String name) {
    //     return helloApi.hello(name);
    // }
    //
    // @RequestMapping("/hello3")
    // public String hello(Integer age, String name) {
    //     return helloApi.hello(age, name);
    // }
    //
    // @RequestMapping("/hello4")
    // public String hello(@RequestBody UserDTO userDTO) {
    //     return helloApi.hello(userDTO);
    // }


}
