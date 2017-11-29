package com.simple;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@MapperScan("com.simple.mapper")
@EnableEurekaClient
@SpringBootApplication
public class Application {

    @RequestMapping("/")
    public String index() {
        return "hello simple web";
    }

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
