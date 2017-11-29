package com.simple.ribbon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.common.util.RestClientUtil;
import com.simple.constants.ServiceConstants;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/26
 */
@RestController
public class TraceController {
    private Logger logger = LoggerFactory.getLogger(TraceController.class);

    @RequestMapping("trace1")
    public String trace() {
        logger.info("===<call trace-1>===");
        return RestClientUtil.getForObject(ServiceConstants.trace2);
    }
}
