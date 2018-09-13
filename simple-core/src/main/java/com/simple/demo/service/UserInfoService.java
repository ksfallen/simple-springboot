package com.simple.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.simple.common.base.BaseService;
import com.simple.demo.mapper.UserInfoMapper;
import com.simple.demo.model.UserInfo;

/**
 * @author: Jfeng
 * @date: 2018/1/2
 */
public class UserInfoService extends BaseService<UserInfo> {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo selectByName(String userName) {
        UserInfo record = new UserInfo();
        record.setUserName(userName);
        return findOne(record);
    }
}
