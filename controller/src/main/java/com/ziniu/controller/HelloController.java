package com.ziniu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/16 0016 15:20
 */
@Controller
@RequestMapping("/templates")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){

        return "hello";
    }
}
