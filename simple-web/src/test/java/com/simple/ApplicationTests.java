package com.simple;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
public class ApplicationTests {

    @Autowired
    protected MockMvc mvc;

    @Test
    public void contextLoads() {
    }

    public String httpGet(String url,  Objects params) throws Exception {
        return getAction(url, params)
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    public String httpPost(String url,  Objects params) throws Exception {
        return postAction(url, params)
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    public ResultActions getAction(String url, Object object) throws Exception {
        String json = "";
        if (object == null) {
             json = JSONObject.toJSONString(object);
        }


        return mvc.perform(
                get(url)
                        .characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));
    }


    public ResultActions postAction(String url, Object object) throws Exception {
        String json = "";
        if (object == null) {
            json = JSONObject.toJSONString(object);
        }

        return mvc.perform(
                get(url)
                        .characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));
    }


}
