package com.simple.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simple.common.base.BaseController;
import com.simple.common.util.SpringContext;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/26
 */
@RestController
public class TraceController extends BaseController {

    @RequestMapping("trace2")
    public String trace() {
        logger.info("===<call trace-2>===");
        return "Trece";
    }
    
}
