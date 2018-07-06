package com.simple.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.common.base.BaseService;
import com.simple.demo.mapper.SysRolePermissionMapper;
import com.simple.demo.model.sys.SysRolePermission;

@Service
public class SysRolePermissionService extends BaseService<SysRolePermission> {
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;
}
