package com.simple.demo.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.simple.common.base.AbstractApplicationTest;
import com.simple.common.base.bean.ResultBean;
import com.simple.entity.dto.AppInfoDTO;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/17
 */
public class AppControllerTest extends AbstractApplicationTest {

    @Autowired
    private AppController appController;

    @Test
    public void getAppInfo() {
        ResultBean<AppInfoDTO> info = appController.getAppInfo(43);
        System.out.println(info.toString());
    }

    @Test
    public void test() {
        // AppInfo all = appInfoMapper.getAll2(43, UserInfo.class.getName());
        // System.out.println("all = " + all);
    }

}
