package com.simple.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.OrderComparator;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.multiaction.InternalPathMethodNameResolver;
import org.springframework.web.servlet.mvc.multiaction.MethodNameResolver;

@Component
public class SpringContext implements ApplicationContextAware {

	private static ApplicationContext appContext = null;

	static {
		// 设置XServer模式
		System.setProperty("java.awt.headless", "true");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appContext = applicationContext;
	}

	public static boolean containsBean(String beanName) {
        return appContext != null && appContext.containsBean(beanName);
    }

	public static Object getBean(String beanName) {
		if (appContext != null) {
			return appContext.getBean(beanName);
		}
		return null;
	}

	public static <T> T getBean(Class<T> clazz) {
		if (appContext != null) {
			try {
				return appContext.getBean(clazz);
			} catch (BeansException e) {
				Map<String, T> map = getBeansOfType(clazz);
				for (Map.Entry<String, T> entry : map.entrySet()) {
					if (entry.getValue().getClass().equals(clazz)) {
						return entry.getValue();
					}
				}
				throw e;
			}
		}
		return null;
	}

	public static <T> Map<String, T> getBeansOfType(Class<T> clazz) throws BeansException {
		Map<String, T> map = null;
		if (appContext != null) {
			map = appContext.getBeansOfType(clazz);
			if ((map == null || map.isEmpty()) && appContext.getParent() != null) {
				map = appContext.getParent().getBeansOfType(clazz);
			}
		}
		if (map == null) {
			map = new HashMap<>();
		}
		return map;
	}

	public static <T> T getBean(String beanId, Class<T> clazz) {
		if (appContext != null) {
			return appContext.getBean(beanId, clazz);
		}
		return null;
	}

	public <T> List<Map.Entry<String, T>> getOrderedBeans(Class<T> clazz) {
		Set<Map.Entry<String, T>> caches = getBeansOfType(clazz).entrySet();
		List<Map.Entry<String, T>> list = new ArrayList<>(caches);
		/*
		 * 根据order顺序排列
		 */
		list.sort((e1, e2) -> new OrderComparator().compare(e1.getValue(), e2.getValue()));
		return list;
	}

	public static Method getHandleMethod(HttpServletRequest request, Object handler) throws Exception {
		MethodNameResolver methodNameResolver = new InternalPathMethodNameResolver();
		String methodName = methodNameResolver.getHandlerMethodName(request);

		Map<String, String> pathVariables = (Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        for (Method method : handler.getClass().getMethods()) {
			RequestMapping rm = method.getAnnotation(RequestMapping.class);
			if (rm != null) {
				for (String val : rm.value()) {
					while (pathVariables != null && val.indexOf("{") < val.indexOf("}")) {
						String temp = val.substring(val.indexOf("{") + 1, val.indexOf("}"));
						val = val.replace("{" + temp + "}", pathVariables.get(temp));
					}
					if ("".equals(val) || methodName.equals(val)) {
						return method;
					}
				}
			}
		}
		return null;
	}

}
