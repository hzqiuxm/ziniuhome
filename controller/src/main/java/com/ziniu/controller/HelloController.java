package com.ziniu.controller;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/16 0016 15:20
 */
@Controller
@RequestMapping("/templates1")
public class HelloController {

    @Autowired
    StringEncryptor stringEncryptor;

    @RequestMapping("/hello")
    public String hello(){

        String result = stringEncryptor.encrypt("123456");
        System.out.println(result);

        return "hello";
    }


//    @RequestMapping("/mima")
//    public String encryptPwd() {
//        String result = stringEncryptor.encrypt("123456");
//        System.out.println(result);
//
//        return "hello";
//    }

}
