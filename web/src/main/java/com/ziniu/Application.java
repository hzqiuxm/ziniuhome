package com.ziniu;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import javax.jms.Queue;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/1 0001 10:39
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ziniu"})
@EnableEncryptableProperties
@ServletComponentScan
public class Application {


    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");
    }



    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

}
