package com.simple.config.mvc.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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
@ControllerAdvice
@ResponseBody
public class DefaultExceptionHandler {

    //    @Resource
    //    private ReloadableResourceBundleMessageSource messageSource;

    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    public ResultBean handleBindException(BindException e, MethodArgumentNotValidException ex) {
        log.error("handleBindException:", e);
        ResultBean result = ResultBeanBuilder.create().withResultMessage(ResultMessage.PARAMETER_ERROR).build();

        // 设参数绑定错误的具体信息
        if (e.hasFieldErrors()) {
            FieldError field = e.getFieldErrors().get(0);
            String msg = field.getRejectedValue() != null ? field.getDefaultMessage() : field.getField() + ":" + field.getDefaultMessage();
            result.setMessage(msg);
        }

        if (ex != null && ex.getBindingResult().hasFieldErrors()) {
            FieldError field = ex.getBindingResult().getFieldError();
            String msg = field.getRejectedValue() != null ? field.getDefaultMessage() : field.getField() + ":" + field.getDefaultMessage();
            result.setMessage(msg);
        }

        // ModelAndView mv = new ModelAndView();
        // mv.setView(new MappingJackson2JsonView());
        // mv.addObject("resultCode", PARAMS_ERROR.getCode());
        // mv.addObject("resultDesc", PARAMS_ERROR.getMsg());
        // return mv;

        return result;
    }

    //
    // @ExceptionHandler({BaseException.class})
    // public ResultBean handleBaseException(BaseException e) {
    //     log.error("handleBaseException desc:", e);
    //     ResultBean result = ResultBeanBuilder.error().withCode(e.getCode()).withMessage(e.getMessage()).build();
    //     // 读取配置在 validator.properties 的 Message
    //     // String msg = messageSource.getMessage(e.getMessage(), null, e.getMessage(), Locale.CHINA);
    //     // result.setMessage(msg);
    //     return result;
    // }

    @ExceptionHandler({Exception.class})
    public ResultBean handleException(HttpServletRequest req, Exception e) {
        log.error("handleException url: {}", req.getRequestURL(), e);

        // 处理 404
        if (e instanceof NoHandlerFoundException) {
            return ResultBeanBuilder.create().withResultMessage(ResultMessage.NO_HANDLER_ERROR).build();
        }


        if (e instanceof HttpRequestMethodNotSupportedException) {
            return ResultBeanBuilder.create().withResultMessage(ResultMessage.ERROR_SYS).withMessage(e.getMessage()).build();
        }

        if (e instanceof BaseException) {
            BaseException ex = (BaseException) e;
            // 读取配置在 validator.properties 的 Message
            // String msg = messageSource.getMessage(e.getMessage(), null, e.getMessage(), Locale.CHINA);
            // result.setMessage(msg);
            return ResultBeanBuilder.error().withCode(ex.getCode()).withMessage(ex.getMessage()).build();
        }

        return ResultBeanBuilder.error().withResultMessage(ResultMessage.ERROR_SYS).build();
    }


}
