package com.simple.demo.entity.model;

import java.util.Date;


import com.simple.common.bean.BaseBean;


public class AppInfo extends BaseBean {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
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
     * tone 中的应用 Id
     */
    private String toneAppId;

    /**
     * 拥有者ID
     */
    private String ownerId;

    /**
     * 输入日期
     */
    private Date inputDate;

    /**
     * 更新时间
     */
    private Date stampDate;

    public Integer getAppInfoId() {
        return appInfoId;
    }

    public void setAppInfoId(Integer appInfoId) {
        this.appInfoId = appInfoId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc == null ? null : appDesc.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getToneAppId() {
        return toneAppId;
    }

    public void setToneAppId(String toneAppId) {
        this.toneAppId = toneAppId == null ? null : toneAppId.trim();
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getStampDate() {
        return stampDate;
    }

    public void setStampDate(Date stampDate) {
        this.stampDate = stampDate;
    }
}
