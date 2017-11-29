package com.simple.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.simple.business.api.HelloBusinessService;
import com.simple.common.util.JsonUtil;
import com.simple.entity.dto.UserDTO;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/24
 */
@Service
public class HelloBusinessServiceImpl implements HelloBusinessService {

    @Autowired
    private DiscoveryClient client;


    @Override
    public String hello() {
        List<String> services = client.getServices();

        List<Map<String, String>> list = new ArrayList<>();

        services.forEach(s -> client.getInstances(s).forEach(instance -> {
            HashMap<String, String> map = Maps.newHashMap();
            map.put("host", instance.getHost());
            map.put("serviceId", instance.getServiceId());
            list.add(map);
        }));


        ServiceInstance instance = client.getInstances(services.get(0)).get(0);
        // String msg = "host:" + instance.getHost() + " service_id:" + instance.getServiceId();
        return JsonUtil.toJsonString(list);
    }


    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

    @Override
    public String hello(Integer age, String name) {
        UserDTO dto = new UserDTO(age, name);
        return "Hello " + dto.toString();
    }

    @Override
    public String hello(UserDTO userDTO) {
        return "Hello " + userDTO.getName() + " age:" + userDTO.getAge();
    }

}
