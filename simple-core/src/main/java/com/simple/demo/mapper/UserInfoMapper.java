package com.simple.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.simple.common.base.BaseMapper;
import com.simple.demo.model.UserInfo;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
