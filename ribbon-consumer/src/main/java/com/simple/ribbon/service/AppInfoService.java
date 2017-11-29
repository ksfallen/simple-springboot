package com.simple.ribbon.service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.TypeReference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.simple.common.base.BaseBusinessService;
import com.simple.common.base.bean.ResultBean;
import com.simple.common.base.bean.ResultBeanBuilder;
import com.simple.common.util.JsonUtil;
import com.simple.common.util.RestClientUtil;
import com.simple.constants.ServiceConstants;
import com.simple.entity.dto.AppInfoDTO;

import static com.simple.constants.ServiceConstants.app_getAppInfo;


/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/17
 */
@Service
public class AppInfoService extends BaseBusinessService {

    @Autowired
    private RestTemplate restTemplate;

    public ResultBean<AppInfoDTO> getAppInfo(Integer appInfoId) {
        AppInfoDTO dto = new AppInfoDTO();
        dto.setAppInfoId(43);
        String str = RestClientUtil.getForObject(app_getAppInfo, dto);
        ResultBean<AppInfoDTO> resultBean = JsonUtil.parseByTypeReference(str, new TypeReference<ResultBean<AppInfoDTO>>(){});
        return resultBean;
    }

    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String hello2() {
        try {
            // 测试断路,  hystrix 默认是2秒
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String object = RestClientUtil.getForObject(ServiceConstants.hello);
        return object;
    }

    /**
     * 异步请求
     * @return
     */
    @HystrixCommand
    public Future<String> hello() {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return RestClientUtil.getForObject(ServiceConstants.hello);
            }
        };
    }

    private String helloFallBack() {
        return ResultBeanBuilder.error().withDesc("helloFallBack desc").build().toString();
    }
}
