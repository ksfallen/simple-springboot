// package com.simple.config.mvc.interceptor;
//
// import java.util.Map;
//
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
//
// import org.springframework.web.method.HandlerMethod;
// import org.springframework.web.servlet.ModelAndView;
// import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
// import com.simple.common.util.RequestUtil;
//
// import lombok.extern.slf4j.Slf4j;
//
// /**
//  * 日志拦截器
//  * User: Jfeng
//  * Date: 2017/3/7
//  */
// @Slf4j
// public class LoggerInterceptor extends HandlerInterceptorAdapter {
//
//     public static final String RESPONSE_FOR_LOGGER = "response_for_logger";
//
//     @Override
//     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//         if (request.getRequestURI() != null && handler instanceof HandlerMethod) {
//             // HandlerMethod method = (HandlerMethod) handler;
//             //
//             // Annotation annotation = method.getBeanType().getAnnotation(RestController.class);
//             // if (annotation == null) {
//             //     annotation =  method.getMethodAnnotation(ResponseBody.class);
//             // }
//             //
//             // if (annotation == null) {
//             //     return true;
//             // }
//
//             log.info("req -> host:{} prot:{} sessionid:{}, url:{}, {}",
//                     request.getRemoteHost(),
//                     request.getRemotePort(),
//                     request.getRequestedSessionId(),
//                     request.getRequestURI(),
//                     RequestUtil.getParams(request));
//         }
//
//         return true;
//     }
//
//     @Override
//     public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//         if (request.getRequestURI() != null && handler instanceof HandlerMethod) {
//             Object result = request.getAttribute(RESPONSE_FOR_LOGGER);
//             request.removeAttribute(RESPONSE_FOR_LOGGER);
//             log.info("resp -> url:{}, result:{}", request.getRequestURI(), result);
//         }
//     }
//
// }
