package com.simple.business.api;

import com.simple.common.base.bean.ResultBean;
import com.simple.entity.dto.AppInfoDTO;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/17
 */
public interface AppInfoBusinessService {
    ResultBean<AppInfoDTO> getAppInfo(Integer appInfoId);
}
