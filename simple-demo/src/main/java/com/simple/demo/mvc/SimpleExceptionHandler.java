package com.simple.demo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.client.ClientException;
import com.simple.common.base.bean.ResultBean;
import com.simple.common.base.bean.ResultBeanBuilder;
import com.simple.common.constants.enums.ResultMessage;
import com.simple.config.mvc.advice.DefaultExceptionHandler;

import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@ResponseBody
@Slf4j
public class SimpleExceptionHandler extends DefaultExceptionHandler {

    @Override
    public ResultBean handleException(HttpServletRequest req, Exception e) {

        // Feign 调用异常
        if (e.getCause() != null && e.getCause() instanceof ClientException) {
            log.error("handleException url: {}", req.getRequestURL(), e);
            ClientException ex = (ClientException) (e.getCause());
            return ResultBeanBuilder.error().withResultMessage(ResultMessage.ERROR_SYS).withMessage(ex.getMessage()).build();
        }

        if (e instanceof RetryableException) {
            log.error("handleException url: {}", req.getRequestURL(), e);
            return ResultBeanBuilder.error().withResultMessage(ResultMessage.ERROR_SYS).withMessage(e.getMessage()).build();
        }

        return super.handleException(req, e);
    }


}
