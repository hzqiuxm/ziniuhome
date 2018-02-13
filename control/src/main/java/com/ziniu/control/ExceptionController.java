package com.ziniu.control;

import com.ziziu.common.Const;
import com.ziziu.common.exception.ParamCheckException;
import com.ziziu.common.exception.ZiniuException;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
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
public class ExceptionController extends BaseController{

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ModelMap exception(BindException exception, WebRequest webRequest){

        System.out.println("=======BindException======" + exception.getBindingResult().getFieldError().getDefaultMessage());

        return getFailResult(Const.ParamCheck.PARAM_IVALID,exception.getBindingResult().getFieldError().getDefaultMessage());
    }


}
