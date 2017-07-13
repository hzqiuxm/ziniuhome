package com.ziniu.controller;

import com.ziniu.repository.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/4/17 0017 14:06
 */
@Controller
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping("/")
    public String index(Model model){
        Msg msg =  new Msg("测试标题---","测试内容---","额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "home";
    }


    @RequestMapping("/login")
    public String login(){

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");

        return "login";
    }



}
