package com.simple.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.common.base.BaseService;
import com.simple.demo.mapper.SysPermissionMapper;
import com.simple.demo.model.sys.SysPermission;

@Service
public class SysPermissionService extends BaseService<SysPermission> {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
}
