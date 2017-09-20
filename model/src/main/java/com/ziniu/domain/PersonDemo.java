package com.ziniu.domain;

import java.io.Serializable;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/2 0002 20:52
 */
public class PersonDemo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private Integer age;

    public PersonDemo() {
        super();
    }

    public PersonDemo(String id, String name, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
