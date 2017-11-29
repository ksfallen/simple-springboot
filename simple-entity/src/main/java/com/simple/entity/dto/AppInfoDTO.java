package com.simple.entity.dto;

import java.util.Date;

import com.simple.common.base.bean.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppInfoDTO extends BaseBean {
    private static final long serialVersionUID = -9138357859860047474L;

    private Integer appInfoId;
    /**
     * 应用名称
     */
    private String appName;

    /**
     * 应用简介
     */
    private String appDesc;

    /**
     * 当前应用状态
     */
    private String status;

    /**
     * 拥有者ID
     */
    private String ownerId;

    /**
     * 更新时间
     */
    private Date stampDate;

}
