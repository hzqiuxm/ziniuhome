package com.ziziu.common.constants;

public enum  ZiniuEnum {
    LOGINNAME_PASSWORD_NULL(10000,"用户名密码为空！"),
    LOGINNAME_PASSWORD_ERROR(10001,"用户名密码错误！"),
    USERINFO_NULL(10002,"用户注册的信息为空 ！"),
    USERINFO_ERROR(10003,"注册信息格式不正确！");

    private int key;
    private String value;

    ZiniuEnum(int key,String value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){return key;}

    public String getValue(){return value;}
}
