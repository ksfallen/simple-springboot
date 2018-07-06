package com.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.api.AppInfoApi;
import com.simple.common.base.bean.ResultBean;
import com.simple.common.base.bean.ResultBeanBuilder;
import com.simple.common.util.BeanUtil;
import com.simple.demo.model.AppInfo;
import com.simple.demo.service.AppInfoService;
import com.simple.entity.dto.AppInfoDTO;


@RestController
public class AppInfoServiceImpl implements AppInfoApi {

    @Autowired
    private AppInfoService appInfoService;

    @Override
    public ResultBean<AppInfoDTO> getAppInfo(@PathVariable Integer appInfoId) {
        AppInfo appInfo = appInfoService.selectById(appInfoId);
        AppInfoDTO bean = BeanUtil.copyProperties(appInfo, AppInfoDTO.class);
        return ResultBeanBuilder.success().withData(bean).build();
    }
}
