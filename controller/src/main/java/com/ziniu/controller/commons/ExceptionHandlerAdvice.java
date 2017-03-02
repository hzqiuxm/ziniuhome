package com.ziniu.controller.commons;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/2/25 0025 19:07
 * 统一的异常捕获处理类
 */
@ControllerAdvice
 //声明控制器建言，已组合Component
public class ExceptionHandlerAdvice {

    //定义全局异常处理，拦截所有异常，可以根据实际情况过滤
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView exception(Exception exception, WebRequest webRequest){
//        System.out.println("---------exception()---------");
//        ModelAndView modelAndView = new ModelAndView("error");
//        modelAndView.addObject("errorMessage",exception.getMessage());
//        System.out.println("exception.getMessage()= " + exception.getMessage());
//        return modelAndView;
//    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exception(Exception exception, WebRequest webRequest ){
        System.out.println("---------exception()---------"+exception.getMessage());
        return exception.getMessage();
    }

    //将键值对添加到全局,所有注解了@RequestMapping的方法都可以获得此键值
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg","全局的额外信息");
    }

    //自动绑定前台参数
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }
}
