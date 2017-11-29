package com.simple.feign.service;

import com.simple.business.api.HelloBusinessService;
import com.simple.entity.dto.UserDTO;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/25
 */
public class HelloServiceFallback implements HelloBusinessService {

    @Override
    public String hello() {
        return "desc";
    }

    @Override
    public String hello(String name) {
        return "desc";
    }

    @Override
    public String hello(Integer age, String name) {
        return new UserDTO(0, "未知").toString();
    }

    @Override
    public String hello(UserDTO userDTO) {
        return "desc";
    }
}
