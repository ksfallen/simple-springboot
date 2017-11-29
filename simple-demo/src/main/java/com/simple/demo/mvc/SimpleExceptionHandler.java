package com.simple.demo.mvc;

import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.config.advice.DefaultExceptionHandler;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/1
 */
@RestController
@ControllerAdvice()
public class SimpleExceptionHandler extends DefaultExceptionHandler {

}
