package com.simple.controller;

import com.simple.mapper.UserMapper;
import com.simple.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: Jfeng
 * Date: 2017/6/2
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("findAll")
    public List<User> findAll() {
        return userMapper.selectAll();
    }

}
