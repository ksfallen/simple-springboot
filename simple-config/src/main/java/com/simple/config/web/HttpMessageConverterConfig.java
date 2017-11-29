package com.simple.config.web;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.collect.Lists;
import com.simple.common.util.JsonUtil;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/9/30
 */
public class HttpMessageConverterConfig {

    public static HttpMessageConverter stringHttpMessageConverter() {
        List<MediaType> list = Lists.newArrayList(MediaType.TEXT_PLAIN, MediaType.ALL);
        StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converter.setSupportedMediaTypes(list);
        return converter;
    }

    public static FormHttpMessageConverter formHttpMessageConverter() {
        List<MediaType> list = Lists.newArrayList(MediaType.APPLICATION_FORM_URLENCODED, MediaType.MULTIPART_FORM_DATA);
        FormHttpMessageConverter converter = new AllEncompassingFormHttpMessageConverter();
        // converter.setCharset(StandardCharsets.UTF_8);
        // converter.setSupportedMediaTypes(list);
        return converter;
    }

    /**
     * 使用 FastJson 代替 Jackson
     * 1、先定义一个convert转换消息的对象
     * 2、添加fastjson的配置信息，比如是否要格式化返回的json数据；
     * 3、在convert中添加配置信息
     * 4、将convert添加到converters
     */
    public static HttpMessageConverter fastJsonHttpMessageConverter() {

        //1、先定义一个convert转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        //附加：处理中文乱码
        List<MediaType> fastMedisTypes = new ArrayList<>();
        fastMedisTypes.add(MediaType.APPLICATION_JSON_UTF8);
        // fastMedisTypes.add(MediaType.TEXT_PLAIN);
        fastConverter.setSupportedMediaTypes(fastMedisTypes);

        //2、添加fastjson的配置信息
        //3、在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig());

        // 4、将convert添加到converters
        // new HttpMessageConverters(fastConverter);

        return fastConverter;
    }


    /**
     * fastjson 配置信息
     * 修改全局日输出期格式 默认 "yyyy-MM-dd HH:mm:ss"
     * @return
     */
    private static FastJsonConfig fastJsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.getSerializeConfig().put(Date.class, JsonUtil.simpleDateFormat);
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat);

        return fastJsonConfig;
    }
}
