package com.simple.demo.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.yhml.core.base.bean.BaseParamBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppInfo extends BaseParamBean {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appInfoId;

    /**
     * 应用简介
     */
    private String appDesc;


    /**
     * 应用名称
     */
    private String appName;

    /**
     * 当前应用状态
     */
    private String status;

    /**
     * tone 中的应用 Id
     */
    private String toneAppId;

    /**
     * 拥有者ID
     */
    private Integer ownerId;

    /**
     * 输入日期
     */
    private Date inputDate;

    /**
     * 更新时间
     */
    private Date stampDate;

    @Transient
    private UserInfo userInfo;

}
