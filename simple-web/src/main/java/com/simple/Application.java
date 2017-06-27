package com.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.simple.mapper")
public class Application {

    @RequestMapping("/")
    public String index() {
        return "hello spring boot";
    }

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
