package com.ziniu.controller;


import com.ziniu.domain.UmUserBase;
import com.ziniu.service.Interface.IUmUserBaseService;
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
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUmUserBaseService iUmUserBaseService;

    @RequestMapping("add")
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
