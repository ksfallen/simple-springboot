package com.simple.demo.model.sys;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.yhml.core.base.bean.BaseParamBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysUserRole extends BaseParamBean {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userInfoId;

    private Integer roleId;
}
