package com.simple.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.common.base.BaseService;
import com.simple.demo.mapper.AppInfoMapper;
import com.simple.demo.model.AppInfo;

@Service
public class AppInfoService extends BaseService<AppInfo> {

    @Autowired
    private AppInfoMapper appInfoMapper;

    @Override
    public AppInfo findById(Integer id) {
        return appInfoMapper.findById2(id);
    }
}
