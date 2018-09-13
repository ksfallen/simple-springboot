package com.simple.demo.config;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.netflix.client.ClientException;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.simple.common.base.bean.ResultBeanBuilder;
import com.simple.config.mvc.advice.DefaultExceptionHandler;

import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;

import static com.simple.common.constants.enums.ResultMessage.SERVICE_NOT_AVAILABLE;

@RestControllerAdvice
public class SimpleExceptionHandler extends DefaultExceptionHandler {

    // public ResultBean handleException(HttpServletRequest req, Exception e) {
    //
    //     // Feign 调用异常
    //     if (e.getCause() != null && e.getCause() instanceof ClientException) {
    //         log.error("handleException url: {}", req.getRequestURL(), e);
    //         ClientException ex = (ClientException) (e.getCause());
    //         String[] ss = ex.getMessage().split(":");
    //         String msg = ex.getMessage();
    //         if (ArrayUtils.isNotEmpty(ss) && ss.length > 1) {
    //             msg = SERVICE_NOT_AVAILABLE.getMessage() + ":" + ss[1];
    //         }
    //         return ResultBeanBuilder.error().withResultMessage(SERVICE_NOT_AVAILABLE).withMessage(msg).build();
    //     }
    //
    //     if (e instanceof RetryableException || e instanceof HystrixBadRequestException) {
    //         log.error("handleException url: {}", req.getRequestURL(), e);
    //         return ResultBeanBuilder.error().withResultMessage(SERVICE_NOT_AVAILABLE).withMessage(e.getMessage()).build();
    //     }
    //
    //     return super.handleException(req, e);
    // }

    @Override
    protected void customHandleException(Exception ex, ResultBeanBuilder builder) {
        // Feign 调用异常
        if (ex.getCause() != null && ex.getCause() instanceof ClientException) {
            ClientException e = (ClientException) (ex.getCause());

            String[] ss = e.getMessage().split(":");
            String msg = e.getMessage();
            if (ArrayUtils.isNotEmpty(ss) && ss.length > 1) {
                msg = SERVICE_NOT_AVAILABLE.getMessage() + ":" + ss[1];
            }
            builder.withCode(SERVICE_NOT_AVAILABLE.getCode()).withMessage(msg);
        }

        if (ex instanceof RetryableException || ex instanceof HystrixBadRequestException) {
            builder.withCode(SERVICE_NOT_AVAILABLE.getCode()).withMessage(ex.getMessage());
        }
    }
}
