package com.simple.config;

import java.util.ArrayList;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: Jfeng
 * @date: 2018/4/18
 */
@Configuration
@PropertySource(value = {"classpath:common.properties"}, ignoreResourceNotFound = true)
public class SimpleConfiguration {


    // @Bean
    // public RedisConnectionFactory getRedisConnectionFactory() {
    //     JedisConnectionFactory factory = new JedisConnectionFactory();
    //     factory.setHostName(config.getRedisHost());
    //     factory.setPort(config.getRedisPort());
    //     factory.setPassword(config.getRedisPassword());
    //     factory.setDatabase(config.getRedisDbIndex());
    //     factory.setUsePool(true);
    //     factory.afterPropertiesSet();
    //     return factory;
    // }
    //
    // @Bean
    // @Primary
    // public RedisTemplate<String, Object> getRedisTemplate() {
    //     RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    //     redisTemplate.setConnectionFactory(getRedisConnectionFactory());
    //     redisTemplate.setKeySerializer(new StringRedisSerializer());
    //     redisTemplate.setValueSerializer(jackson2JsonRedisSerializer());
    //     redisTemplate.afterPropertiesSet();
    //     return redisTemplate;
    // }
    //
    // @Bean
    // public CacheManager cacheManager() {
    //     RedisCacheManager rcm = new RedisCacheManager(getRedisTemplate());
    //     ArrayList<String> cacheNames = new ArrayList<>();
    //     cacheNames.add(RedisCache.CACHE_NAME);
    //     rcm.setCacheNames(cacheNames);
    //     rcm.setDefaultExpiration(config.getRedisExpiration());
    //     return rcm;
    // }


}
