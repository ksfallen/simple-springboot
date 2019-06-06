package com.simple.common.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.MySqlMapper;


public interface BaseMapper<T> extends  Mapper<T>, MySqlMapper {

}
