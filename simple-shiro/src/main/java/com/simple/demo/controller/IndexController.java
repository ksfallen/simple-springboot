package com.simple.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/9/28
 */
@Controller
public class IndexController {

    @RequestMapping({"/"})
    @ResponseBody
    public String index(){
        return"index";
    }

}
