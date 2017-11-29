package com.simple.demo.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.simple.common.base.BaseMapper;
import com.simple.demo.model.AppInfo;

@Mapper
public interface AppInfoMapper extends BaseMapper<AppInfo> {

}
