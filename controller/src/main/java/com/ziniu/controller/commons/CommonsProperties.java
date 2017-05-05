package com.ziniu.controller.commons;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/2 0002 20:06
 * 负责注入需要的属性bean
 */
@Component
@ConfigurationProperties("ziniu")
public class CommonsProperties{

    private String yinyoushiren;
    private String defaultjms;
    private String goldjms;

    public String getDefaultjms() {
        return defaultjms;
    }

    public void setDefaultjms(String defaultjms) {
        this.defaultjms = defaultjms;
    }

    public void setYinyoushiren(String yinyoushiren){

        this.yinyoushiren = yinyoushiren;
    }

    public String getYinyoushiren(){
        return yinyoushiren;
    }

    public String getGoldjms() {
        return goldjms;
    }

    public void setGoldjms(String goldjms) {
        this.goldjms = goldjms;
    }
}
