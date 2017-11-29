package com.simple.config.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.simple.common.util.RequestUtil;
import com.simple.config.interceptor.LoggerInterceptor;

/**
 * Cotroller 响应结果统一处理
 * @author: Jianfeng.Hu
 * @date: 2017/10/3
 */
// @ControllerAdvice
// @Order(1)
public class ResultBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        HttpServletRequest requset = RequestUtil.getRequest();
        requset.setAttribute(LoggerInterceptor.RESPONSE_FOR_LOGGER, body);
        return body;
    }
}
