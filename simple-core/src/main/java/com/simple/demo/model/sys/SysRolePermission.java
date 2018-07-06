package com.simple.demo.model.sys;

import com.simple.common.base.bean.BaseParamBean;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysRolePermission extends BaseParamBean {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer sysRoleId;

    private Integer sysPermissionId;
}
