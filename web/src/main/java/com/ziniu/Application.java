package com.ziniu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/1 0001 10:39
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ziniu"})
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
