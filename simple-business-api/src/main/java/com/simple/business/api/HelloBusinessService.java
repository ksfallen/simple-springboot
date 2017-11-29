package com.simple.business.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.entity.dto.UserDTO;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/24
 */
public interface HelloBusinessService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping("/hello2")
    String hello(@RequestParam("name") String name);

    @RequestMapping("/hello3")
    String hello(@RequestParam("age") Integer age, @RequestParam("name") String name);

    @RequestMapping("/hello4")
    String hello(@RequestBody UserDTO userDTO);


}
