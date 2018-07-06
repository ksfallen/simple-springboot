package com.simple.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.common.base.BaseService;
import com.simple.demo.mapper.SysUserRoleMapper;
import com.simple.demo.model.sys.SysUserRole;

@Service
public class SysUserRoleService extends BaseService<SysUserRole> {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
}
