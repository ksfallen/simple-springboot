package com.simple.demo.model.sys;

import com.simple.common.base.bean.BaseParamBean;
import javax.persistence.*;
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
