package com.simple.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.common.base.BaseController;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/9/25
 */
@RestController
@RequestMapping(value = "app", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AppController extends BaseController {

    // @Autowired
    // private AppInfoBusinessService appInfoBusinessService;
    //
    //
    // @RequestMapping("/getAppInfo")
    // public ResultBean<AppInfoDTO> getAppInfo(Integer appInfoId) {
    //     return appInfoBusinessService.getAppInfo(appInfoId);
    // }
    //
    // @RequestMapping("/info")
    // @ResponseBody
    // public Object info() {
    //     AppInfo info = new AppInfo();
    //     info.setAppName("name");
    //     info.setAppDesc("desc");
    //     return info;
    // }


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
