package com.simple.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/26
 */
@RestController
public class TraceController {

    private Logger logger = LoggerFactory.getLogger(TraceController.class);

    @RequestMapping("trace2")
    public String trace() {
        logger.info("===<call trace-2>===");
        return "Trece";
    }

}
