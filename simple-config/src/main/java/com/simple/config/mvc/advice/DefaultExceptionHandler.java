package com.simple.config.mvc.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.simple.common.base.bean.ResultBean;
import com.simple.common.base.bean.ResultBeanBuilder;
import com.simple.common.exception.BaseException;

import lombok.extern.slf4j.Slf4j;

import static com.simple.common.constants.enums.ResultMessage.ERROR_ARGS;

/**
 * 默认异常处理类
 *
 * @author: Jianfeng.Hu
 * @date: 2017/9/30
 */
@Slf4j
@RestControllerAdvice
public abstract class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    //    @Resource
    //    private ReloadableResourceBundleMessageSource messageSource;

    // @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    // public ResultBean handleBindException(BindException e, MethodArgumentNotValidException ex) {
    //     log.error("handleBindException", e);
    //     ResultBean result = ResultBeanBuilder.builder().withResultMessage(ResultMessage.PARAMETER_ERROR).build();
    //
    //     // 设参数绑定错误的具体信息
    //     if (e.hasFieldErrors()) {
    //         FieldError field = e.getFieldErrors().get(0);
    //         String msg = field.getRejectedValue() != null ? field.getDefaultMessage() : field.getField() + ":" + field
    // .getDefaultMessage();
    //         result.setMessage(msg);
    //     }
    //
    //     if (ex != null && ex.getBindingResult().hasFieldErrors()) {
    //         FieldError field = ex.getBindingResult().getFieldError();
    //         String msg = field.getRejectedValue() != null ? field.getDefaultMessage() : field.getField() + ":" + field
    // .getDefaultMessage();
    //         result.setMessage(msg);
    //     }
    //
    //     // ModelAndView mv = new ModelAndView();
    //     // mv.setView(new MappingJackson2JsonView());
    //     // mv.addObject("resultCode", PARAMS_ERROR.getCode());
    //     // mv.addObject("resultDesc", PARAMS_ERROR.getMsg());
    //     // return mv;
    //
    //     return result;
    // }

    @ExceptionHandler({Exception.class})
    public ResultBean handleException(HttpServletRequest req, Exception e) {
        log.error("handleException URI:{}", req.getRequestURI(), e);

        ResultBeanBuilder builder = ResultBeanBuilder.error();

        if (e instanceof BaseException) {
            BaseException ex = (BaseException) e;
            // 读取配置在 validator.properties 的 Message
            // String msg = messageSource.getMessage(e.getMessage(), null, e.getMessage(), Locale.CHINA);
            builder.withCode(ex.getCode()).withMessage(ex.getMessage()).build();
        } else {
            customHandleException(e, builder);
        }

        return builder.build();
    }

    protected abstract void customHandleException(Exception ex, ResultBeanBuilder builder);

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status,
                                                             WebRequest request) {
        log.error("handleException {}", request);

        ResultBeanBuilder builder = ResultBeanBuilder.error().withCode(String.valueOf(status.value())).withMessage(ex.getMessage());
        if (ex instanceof BindException) {
            BindException e = (BindException) ex;
            // 设参数绑定错误的具体信息
            if (e.hasFieldErrors()) {
                FieldError field = e.getFieldErrors().get(0);
                String msg = field.getRejectedValue() != null ? field.getDefaultMessage() : field.getField() + ":" + field
                        .getDefaultMessage();
                builder.withMessage(msg).withCode(ERROR_ARGS.getCode());
            }
        }

        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException e = (MethodArgumentNotValidException) ex;
            if (e != null && e.getBindingResult().hasFieldErrors()) {
                FieldError field = e.getBindingResult().getFieldError();
                String msg = field.getRejectedValue() != null ? field.getDefaultMessage() : field.getField() + ":" + field
                        .getDefaultMessage();
                builder.withMessage(msg).withCode(ERROR_ARGS.getCode());
            }
        }

        if (ex instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException e = (MethodArgumentTypeMismatchException) ex;
            String msg = e.getName() + "=" + e.getValue();
            log.error("Method:{}, Arg:{}", e.getParameter().getMethod().getName(), msg);
            builder.withResultMessage(ERROR_ARGS).withExtendMessage(msg);
        }

        log.error("message:{}", ex.getMessage());
        return new ResponseEntity<>(builder.build(), status);
    }
}
