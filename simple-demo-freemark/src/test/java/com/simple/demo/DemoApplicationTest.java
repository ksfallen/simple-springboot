package com.simple.demo;

import java.util.Objects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.alibaba.fastjson.JSONObject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/9/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTest {

    @Autowired
    protected MockMvc mvc;

    @Test
    public void contextLoads() throws Exception {
        String str = httpGet("/", null);
        System.out.println(str);
    }

    public String httpGet(String url,  Objects params) throws Exception {
        return getAction(url, params)
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    public ResultActions getAction(String url, Object object) throws Exception {
        String json = "";
        if (object != null) {
            json =  JSONObject.toJSONString(object);
        }
        return mvc.perform(
                get(url)
                        .characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));
    }


}
