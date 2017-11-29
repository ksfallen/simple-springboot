package com.simple.demo.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Shiro 配置
 *
 * Apache Shiro 核心通过 Filter 来实现，
 *
 * 是通过URL规则来进行过滤和权限校验，所以我们需要定义一系列关于URL的规则和访问权限。
 *
 * @author: Jianfeng.Hu
 * @date: 2017/10/26
 */
@Configuration
public class ShiroConfiguration {

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     *
     * 注意：单独一个ShiroFilterFactoryBean 配置会报错
     * 因为初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     *
     * Filter Chain定义说明
     * 1、一个URL可以配置多个Filter，使用逗号分隔
     * 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     *
     * Shiro内置的FilterChain
     *
     * anon   org.apache.shiro.web.filter.authc.AnonymousFilter
     * authc  org.apache.shiro.web.filter.authc.FormAuthenticationFilter
     * authcBasic     org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter
     * perms  org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter
     * port   org.apache.shiro.web.filter.authz.PortFilter
     * rest   org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter
     * roles  org.apache.shiro.web.filter.authz.RolesAuthorizationFilter
     * ssl    org.apache.shiro.web.filter.authz.SslFilter
     * user   org.apache.shiro.web.filter.authc.UserFilter
     *
     * anon:    所有url都都可以匿名访问;
     * authc:   需要认证才能进行访问;
     * user:    配置记住我或认证通过可以访问；
*
     * 这时候我们运行程序，访问/index页面我们会发现自动跳转到了login页面，
     * 当然这个时候输入账号和密码是无法进行访问的。下面这才是重点：任何身份认证，如何权限控制。
     *
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){

        ShiroFilterFactoryBean factoryBean  = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        factoryBean.setSecurityManager(securityManager);

        //拦截器.
        Map<String,String> filterChainMap = new LinkedHashMap<>();

        // 配置退出过滤器, 其中的具体的退出代码Shiro已经替我们实现了
        filterChainMap.put("/logout", "logout");

        // 过滤链定义，从上向下顺序执行，
        // 一般将 /**放在最为下边 :这是一个坑呢，一不小心代码就不好使了;
        // authc:所有url都必须认证通过才可以访问;
        // anon:所有url都都可以匿名访问
        filterChainMap.put("/**", "authc");

        // 如果不设置默认会自动寻找Web工程根目录下的"/login"页面
        factoryBean.setLoginUrl("/login");

        // 登录成功后要跳转的链接
        factoryBean.setSuccessUrl("/index");

        // 未授权界面;
        factoryBean.setUnauthorizedUrl("/403");

        factoryBean.setFilterChainDefinitionMap(filterChainMap);

        return factoryBean;
    }


    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        return securityManager;
    }

}
