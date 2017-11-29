package com.simple.demo.mvc;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.config.advice.DefaultExceptionHandler;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/1
 */
@ControllerAdvice
@ResponseBody
public class SimpleExceptionHandler extends DefaultExceptionHandler {

}
