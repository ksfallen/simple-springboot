package com.simple.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.simple.demo.entity.model.AppInfo;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/9/25
 */
@RequestMapping("app")
@Controller
public class AppController {

    /**
     * 简单的后台接口，用于测试
     */
    @RequestMapping("/info")
    @ResponseBody
    public Object info(){
        Map<String,Object> map = new HashMap<>();
        map.put("info","hello hello hello");
        return map;
    }


    @RequestMapping("show")
    public String app(Model model) {
        List<AppInfo> list = new ArrayList<>();
        AppInfo appInfo = new AppInfo();
        appInfo.setAppName("test");
        AppInfo appInfo2 = new AppInfo();
        appInfo2.setAppName("test2");

        list.add(appInfo);
        list.add(appInfo2);

        model.addAttribute("resultList", list);

        return "appinfo/showAppInfo";
    }

    @RequestMapping("config")
    public String appConfig() {
        return "appinfo/showAppConfig";
    }

    @RequestMapping("policy")
    public String showPolicy() {
        return "appinfo/showPolicy";
    }
}
