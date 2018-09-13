package com.simple.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.simple.common.base.BaseMapper;
import com.simple.demo.model.AppInfo;

public interface AppInfoMapper extends BaseMapper<AppInfo> {

    AppInfo findById2(Integer id);

}
