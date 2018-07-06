package com.simple.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.common.base.BaseService;
import com.simple.demo.mapper.SysRoleMapper;
import com.simple.demo.model.sys.SysRole;

@Service
public class SysRoleService extends BaseService<SysRole> {
    @Autowired
    private SysRoleMapper sysRoleMapper;
}
