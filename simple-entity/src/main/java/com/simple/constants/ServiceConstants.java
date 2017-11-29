package com.simple.constants;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/17
 */
public class ServiceConstants {
    private static final String HTTP = "http://";

    //  HELLO-SERVICE
    public static final String HELLO_SERVICE_NAME = "HELLO-SERVICE";
    private static final String HTTP_HELLO_SERVICE = HTTP + HELLO_SERVICE_NAME;

    public static final String short_hello = "/hello";
    public static final String hello = build(HELLO_SERVICE_NAME, short_hello);

    public static final String short_app_getAppInfo = "/app/getAppInfo";
    public static final String app_getAppInfo = build(HELLO_SERVICE_NAME, short_app_getAppInfo);

    public static final String short_trace2 = "/trace2";
    public static final String trace2 = build(HELLO_SERVICE_NAME, short_trace2);

    private static String build(String serviceId, String url) {
        return HTTP + serviceId + url;
    }

}
