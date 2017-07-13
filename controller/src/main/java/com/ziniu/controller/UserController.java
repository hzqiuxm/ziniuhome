package com.ziniu.controller;


import com.ziniu.domain.UmUserBase;
import com.ziniu.service.Interface.IUmUserBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;


/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/4/21 0021 10:10
 */
@Api(description = "用户相关操作接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUmUserBaseService iUmUserBaseService;

    @ApiOperation(value = "增加用户信息",notes = "这里是notes")
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String saveUserInfo(){

        System.out.println("-----------------");
        UmUserBase umUserBase = new UmUserBase();
        umUserBase.setCellNum("15990001592");
        umUserBase.setUserName("handan");
        umUserBase.setStatus((byte) 1);
        umUserBase.setPassword("123321");
        umUserBase.setGmtCreate(new Date());
        umUserBase.setGmtModfiy(new Date());

        int insert = iUmUserBaseService.insert(umUserBase);
        System.out.println("insert = " + insert);

        return "insert"+insert;
    }


}
