package com.simple.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.business.api.AppInfoBusinessService;
import com.simple.common.base.bean.ResultBean;
import com.simple.common.base.bean.ResultBeanBuilder;
import com.simple.common.util.BeanUtil;
import com.simple.demo.model.AppInfo;
import com.simple.entity.dto.AppInfoDTO;


@Service
public class AppInfoBusinessServiceImpl implements AppInfoBusinessService {

    @Autowired
    private AppInfoService appInfoService;

    @Override
    public ResultBean<AppInfoDTO> getAppInfo(Integer appInfoId) {
        AppInfo appInfo = appInfoService.selectById(appInfoId);
        AppInfoDTO bean = BeanUtil.copyProperties(appInfo, AppInfoDTO.class);
        return ResultBeanBuilder.success().withData(bean).build();
    }
}
