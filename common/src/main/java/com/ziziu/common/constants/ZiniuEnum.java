package com.ziziu.common.constants;


/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @author shengwuyou
 * @data 2017/11/15 0015 14:17
 */

public enum  ZiniuEnum {
    LOGINNAME_PASSWORD_NULL(10000,"用户名密码为空！"),
    LOGINNAME_PASSWORD_ERROR(10001,"用户名密码错误！"),
    USERINFO_NULL(10002,"用户注册的信息为空 ！"),
    USERINFO_ERROR(10003,"注册信息格式不正确！"),
    LOGINNAME_ALERDY_EXIST(10004,"用户名已存在！"),
    LOGINNAME_NOT_EXIST(10005,"用户名不存在！"),
    LOGINNAME_NULL(10006,"请输入loginName！"),
    USER_NO_LOGIN(10007,"用户未登录！"),
    USER_ROLE_TOP(10008,"用户已经是最高权限！"),
    LOGINING_ERROR(10009,"系统异常！")
    ;

    private int key;
    private String value;

    ZiniuEnum(int key,String value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){return key;}

    public String getValue(){return value;}
}
