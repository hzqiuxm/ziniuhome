package com.ziniu.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/16 0016 16:09
 */
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    //自定义图片目录，并不会覆盖springboot的默认配置写成/*就会覆盖默认配置了
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("/app/**").addResourceLocations("classpath:/static/app/commons/css/");

        super.addResourceHandlers(registry);

    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("login");
//    }
}
