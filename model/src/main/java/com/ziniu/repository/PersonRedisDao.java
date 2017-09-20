package com.ziniu.repository;

import com.ziniu.domain.PersonDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/12 0012 14:51
 * Redis的数据库访问层
 */
@Repository
public class PersonRedisDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name="stringRedisTemplate")
    ValueOperations<String,String> valueOpsStr;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Resource(name="redisTemplate")
    ValueOperations<Object,Object> valOps;

    public void stringRedisTemplateDemo(){
        valueOpsStr.set("xx","yy");
    }

    public void save(PersonDemo personDemo){
        valOps.set(personDemo.getId(),personDemo);
    }

    public String getString(){
        return valueOpsStr.get("xx");
    }

    public PersonDemo getPerson(){
        return (PersonDemo) valOps.get("1");
    }

}
