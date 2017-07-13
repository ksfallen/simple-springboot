package com.simple;

import com.alibaba.druid.pool.DruidDataSource;
import com.simple.druid.DruidConfiguration;
import com.simple.util.SpringContext;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@SpringBootApplication
@RestController
@MapperScan("com.simple.mapper")
public class Application {

    @RequestMapping("/")
    public String index() {
        return "hello spring boot2";
    }

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
