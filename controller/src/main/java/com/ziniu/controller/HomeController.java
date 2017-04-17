//package com.ziniu.controller;
//
//import com.ziniu.repository.Msg;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// * Copyright © 2016年 author. All rights reserved.
// *
// * @Author 临江仙 hxqiuxm@163.com
// * @Date 2017/4/17 0017 14:06
// */
//@Controller
////@RequestMapping("/templates")
//public class HomeController {
//
//    @RequestMapping("/")
//    public String index(Model model){
//        Msg msg =  new Msg("测试标题---","测试内容---","额外信息，只对管理员显示");
//        model.addAttribute("msg", msg);
//        return "home";
//    }
//
//    @RequestMapping("/login")
//    public String login(){
//        System.out.println("=======");
//        return "login";
//    }
//
//}
