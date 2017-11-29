package com.simple.ribbon.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.simple.common.base.AbstractApplicationTest;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/17
 */
public class AppInfoControllerTest extends AbstractApplicationTest {
    @Autowired
    private AppInfoController appInfoController;

    @Test
    public void getAppInfo() throws Exception {
        appInfoController.getAppInfo(43);
    }

}
