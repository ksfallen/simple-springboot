package com.simple.config.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.simple.common.base.bean.ResultBean;
import com.simple.common.base.bean.ResultBeanBuilder;
import com.simple.common.constants.enums.ResultMessage;
import com.simple.common.exception.BaseException;

import lombok.extern.slf4j.Slf4j;

/**
 * 默认异常处理类
 *
 * @author: Jianfeng.Hu
 * @date: 2017/9/30
 */
@Slf4j
public class DefaultExceptionHandler {

    //    @Resource
    //    private ReloadableResourceBundleMessageSource messageSource;

    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    public ResultBean handleException(BindException e) {
        log.error("request desc:", e);
        ResultBean result = ResultBeanBuilder.create().withResultMessage(ResultMessage.PARAMETER_ERROR).build();

        // 设参数绑定错误的具体信息
        if (e.hasFieldErrors()) {
            FieldError field = e.getFieldErrors().get(0);
            String msg = field.getRejectedValue() != null ? field.getDefaultMessage() : field.getField() + ":" + field.getDefaultMessage();
            result.setMessage(msg);
        }

        return result;
    }

    @ExceptionHandler({BaseException.class})
    public ResultBean handleBaseException(BaseException e) {
        log.error("request desc:", e);
        ResultBean result = ResultBeanBuilder.error().withCode(e.getCode()).withMessage(e.getMessage()).build();
        // 读取配置在 validator.properties 的 Message
        // String msg = messageSource.getMessage(e.getMessage(), null, e.getMessage(), Locale.CHINA);
        // result.setMessage(msg);
        return result;
    }

    @ExceptionHandler({Exception.class})
    public ResultBean handleException(HttpServletRequest req, Exception e) {
        log.error("desc to handle uri: {}", req.getRequestURI(), e);

        // 处理 404
        if (e instanceof NoHandlerFoundException) {
            return ResultBeanBuilder.create().withResultMessage(ResultMessage.NO_HANDLER_ERROR).build();
        }

        // if (e instanceof SQLException) {
        //     return ResultBeanBuilder.create().withResultMessage(ResultMessage.ERROR_DB).build();
        // }

        return ResultBeanBuilder.error().withMessage(e.getMessage()).withException(e).build();
    }


}
