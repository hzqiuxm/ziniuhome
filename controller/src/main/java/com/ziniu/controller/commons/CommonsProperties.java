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

    public void setYinyoushiren(String yinyoushiren){

        this.yinyoushiren = yinyoushiren;
    }

    public String getYinyoushiren(){
        return yinyoushiren;
    }
}
