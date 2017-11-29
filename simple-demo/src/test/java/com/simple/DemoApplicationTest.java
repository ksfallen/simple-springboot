package com.simple;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.simple.common.base.AbstractApplicationTest;
import com.simple.demo.convert.AppInfoConvert;
import com.simple.demo.model.AppInfo;
import com.simple.entity.dto.AppInfoDTO;

import fr.xebia.extras.selma.Selma;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/30
 */
public class DemoApplicationTest extends AbstractApplicationTest {

    @Autowired
    private AppInfoConvert appInfoDTOMaper;

    public static void main(String[] args) {
        AppInfoDTO appInfoDTO = new AppInfoDTO();
        // appInfoDTO.setAppname("appname");
        appInfoDTO.setOwnerId("1");

        AppInfoConvert appInfoDTOMaper = Selma.builder(AppInfoConvert.class).disableCache().build();
        AppInfo info = appInfoDTOMaper.asModel(appInfoDTO);
        System.out.println("info = " + info);
    }


    @Test
    public void test() {
        AppInfoDTO appInfoDTO = new AppInfoDTO();
        // appInfoDTO.setAppname("appname");
        appInfoDTO.setOwnerId("1");

        AppInfo info = appInfoDTOMaper.asModel(appInfoDTO);
        System.out.println("info = " + info);
    }

}
