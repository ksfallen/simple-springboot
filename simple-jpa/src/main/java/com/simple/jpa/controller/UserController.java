package com.simple.jpa.controller;

import com.simple.jpa.dao.UserRepository;
import com.simple.jpa.model.User;
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
    private UserRepository userRepository;


    @RequestMapping("findAll")
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
