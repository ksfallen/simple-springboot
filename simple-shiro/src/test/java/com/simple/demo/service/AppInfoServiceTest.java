package com.simple.demo.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.simple.common.base.AbstractApplicationTest;
import com.simple.common.base.bean.ResultBean;
import com.simple.common.util.JsonUtil;
import com.simple.demo.model.AppInfo;

import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/4
 */
public class AppInfoServiceTest extends AbstractApplicationTest {

    @Autowired
    private AppInfoService appInfoService;

    @Test
    public void test() {
        AppInfo bean = new AppInfo();
        // appInfoService.insert(bean);

        bean.setPageNum(20);
        bean.setPageSize(0);
        // bean.setOrderBy("appInfoId desc");

        List<AppInfo> list = appInfoService.listByPage(null);
        System.out.println("info = " + list);
        System.out.println("info = " + list.get(9));

    }

}
