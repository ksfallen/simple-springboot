package com.simple.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.common.base.bean.ResultBean;
import com.simple.entity.dto.AppInfoDTO;
import com.simple.ribbon.service.AppInfoService;

/**
 * @author: Jfeng
 * @date: 2017/7/14
 */
@RestController
@RequestMapping("app")
public class AppInfoController {

    @Autowired
    private AppInfoService appInfoService;

    @PostMapping("getAppInfo")
    public ResultBean<AppInfoDTO> getAppInfo(Integer appInfoId) {
        return appInfoService.getAppInfo(appInfoId);
    }
}
