package com.simple.demo.model.sys;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.yhml.core.base.bean.BaseParamBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysPermission extends BaseParamBean {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 是否可用,如果不可用将不会添加给用户
     */
    private Integer available;

    /**
     * 名称
     */
    private String name;

    /**
     * 父编号
     */
    private Integer parentId;

    /**
     * 父编号列表
     */
    private String parentIds;

    /**
     * 权限字符串,menu例子：role:*，button例子：role:builder,role:update,role:delete,role:view
     */
    private String permission;

    /**
     * 资源类型，[menu|button]
     */
    private String resourceType;

    /**
     * 资源路径
     */
    private String url;
}
