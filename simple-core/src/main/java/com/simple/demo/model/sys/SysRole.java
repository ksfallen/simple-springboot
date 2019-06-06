package com.simple.demo.model.sys;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.yhml.core.base.bean.BaseParamBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysRole extends BaseParamBean {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 是否可用,如果不可用将不会添加给用户
     */
    private Integer available;

    /**
     * 角色标识程序中判断使用,如"admin",这个是唯一的:
     */
    private String role;

    /**
     * 角色描述,UI界面显示使用
     */
    private String description;
}
