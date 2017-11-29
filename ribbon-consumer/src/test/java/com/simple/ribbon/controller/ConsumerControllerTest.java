package com.simple.ribbon.controller;

import javax.annotation.Resource;

import org.junit.Test;

import com.simple.common.base.AbstractApplicationTest;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/17
 */
public class ConsumerControllerTest extends AbstractApplicationTest {

    @Resource
    private HelloController controller;

    @Test
    public void hello() throws Exception {
        String consumer = controller.hello();
        System.out.println(consumer);
    }

}
