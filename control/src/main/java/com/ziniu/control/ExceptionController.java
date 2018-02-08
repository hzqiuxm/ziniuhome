package com.ziniu.control;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2018/2/8 16:46
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exception(Exception exception, WebRequest webRequest){

        return exception.getMessage();
    }


}
