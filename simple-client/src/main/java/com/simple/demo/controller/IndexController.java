package com.simple.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.common.annotaton.LocalLock;
import com.simple.common.base.BaseController;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/9/28
 */
@RestController
public class IndexController extends BaseController {

    @GetMapping(value = {"/", "index"})
    public String index() {
        return "Hello demo war !!";
    }

    // @LocalLock(key = "arg[0]")
    @GetMapping("lock")
    public String lock(Integer token) {
        return "success:" + token;
    }

}
