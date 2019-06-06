package com.simple.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simple.demo.service.AppInfoService;
import com.simple.common.base.BaseController;
import com.simple.common.base.bean.ResultBean;
import com.simple.entity.dto.AppInfoDTO;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/9/25
 */
@RestController
@RequestMapping(value = "app", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AppController extends BaseController {

    @Autowired
    private AppInfoService appInfoService;

    @RequestMapping(value = "/getAppInfo", method = RequestMethod.GET)
    public ResultBean<AppInfoDTO> getAppInfo(Integer appInfoId) {
        return appInfoService.getAppInfo(appInfoId);

    }

    @RequestMapping("/info")
    public Object info() {
        AppInfoDTO info = new AppInfoDTO();
        info.setAppName("name");
        info.setAppDesc("desc");
        return info;
    }


    // /**
    //  *
    //  * @param model
    //  * @return
    //  */
    // @RequestMapping("show")
    // public String app(Model model) {
    //     List<AppInfo> list = new ArrayList<>();
    //     AppInfo appInfo = new AppInfo();
    //     appInfo.setAppName("test");
    //     AppInfo appInfo2 = new AppInfo();
    //     appInfo2.setAppName("test2");
    //
    //     list.add(appInfo);
    //     list.add(appInfo2);
    //
    //     model.addAttribute("resultList", list);
    //
    //     return "appinfo/showAppInfo";
    // }
    //
    // @RequestMapping("config")
    // public String appConfig() {
    //     return "appinfo/showAppConfig";
    // }
    //
    // @RequestMapping("policy")
    // public String showPolicy() {
    //     return "appinfo/showPolicy";
    // }
}
