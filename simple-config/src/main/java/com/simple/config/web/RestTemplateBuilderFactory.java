package com.simple.config.web;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import lombok.Getter;
import lombok.Setter;

import static com.simple.config.web.HttpMessageConverterConfig.fastJsonHttpMessageConverter;
import static com.simple.config.web.HttpMessageConverterConfig.formHttpMessageConverter;
import static com.simple.config.web.HttpMessageConverterConfig.stringHttpMessageConverter;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/17
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties("rest")
@PropertySource(value = {"classpath:rest.properties"}, ignoreResourceNotFound = true)
public class RestTemplateBuilderFactory {

    /**
     * 整个连接池最大连接数
     */
    private int maxTotal = 10;

    /**
     * 路由的默认最大连接（该值默认为2），限制数量实际使用DefaultMaxPerRoute并非MaxTotal
     */
    private int defaultMaxPerRoute = 2;

    /**
     * 读写超时时间，毫秒
     */
    private int readTimeout = 10000;

    /**
     * 连接超时时间，毫秒
     */
    private int connectTimeout = 10000;

    // public RestTemplateBuilder create() {
    //     RestTemplate restTemplate = new RestTemplate(requestFactory());
    //     List<HttpMessageConverter<?>> list = Lists.newArrayList(stringHttpMessageConverter(), fastJsonHttpMessageConverter());
    //     restTemplate.setMessageConverters(list);
    //
    //     RestTemplateBuilder builder = new RestTemplateBuilder();
    //     builder.messageConverters(list).requestFactory(requestFactory());
    //
    //     return builder;
    // }

    // public RestTemplateBuilder create2() {
    //     List<HttpMessageConverter<?>> list = Lists.newArrayList(stringHttpMessageConverter(), fastJsonHttpMessageConverter());
    //
    //     RestTemplateCustomizer customizer = restTemplate -> {
    //         restTemplate.setRequestFactory(requestFactory());
    //         restTemplate.setMessageConverters(list);
    //     };
    //
    //    return new RestTemplateBuilder(customizer);
    // }

    public RestTemplateBuilder create() {
        return new RestTemplateBuilder()
                .requestFactory(requestFactory())
                // .messageConverters()
                .additionalMessageConverters(stringHttpMessageConverter())
                .additionalMessageConverters(fastJsonHttpMessageConverter())
                .additionalMessageConverters(formHttpMessageConverter())
                ;
    }


    private PoolingHttpClientConnectionManager pollingConnectionManager() {
        PoolingHttpClientConnectionManager pool = new PoolingHttpClientConnectionManager();
        pool.setMaxTotal(maxTotal);
        pool.setDefaultMaxPerRoute(defaultMaxPerRoute);
        return pool;
    }

    private HttpComponentsClientHttpRequestFactory requestFactory() {
        HttpClientBuilder builder = HttpClientBuilder.create();
        builder.setConnectionManager(pollingConnectionManager());

        //  开启重试
        // requestSentRetryEnabled 开启
        // retryCount 充实次数
        // DefaultHttpRequestRetryHandler retryHandler = new DefaultHttpRequestRetryHandler(1, true);
        // builder.setRetryHandler(retryHandler);

        HttpClient client = builder.build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(client);
        factory.setReadTimeout(readTimeout);
        factory.setConnectTimeout(connectTimeout);


        return factory;
    }


}
