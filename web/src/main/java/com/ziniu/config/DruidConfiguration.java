package com.ziniu.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright © 2016年 author. All rights reserved.
 * druid 配置
 * 这样的方式不需要添加注解：@ServletComponentScan
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/4/21 0021 21:16
 */
@Configuration
public class DruidConfiguration {

    /**
     * 注册一个StatViewServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServle(){

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //IP黑名单与白名单 allow<deny
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        servletRegistrationBean.addInitParameter("deny","192.168.1.100");
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername","wyf");
        servletRegistrationBean.addInitParameter("loginPassword","wyf");
        //是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;

    }

    /**
     * 注册一个StatViewServlet
     * @return
     */
    @Bean
    public FilterRegistrationBean statFilter(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的格式
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        return filterRegistrationBean;
    }


}
