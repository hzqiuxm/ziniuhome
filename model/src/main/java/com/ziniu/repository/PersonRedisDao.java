package com.ziniu.repository;

import com.ziniu.domain.PersonDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
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

    @Resource(name="redisTemplate")
    HashOperations<Object,Object,Object> hashOps;

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

    public Object getsomething(){
        System.out.println("getsomething.....");

        redisTemplate.opsForHash().put("test:1:base","name","dingjiahong");

        Object name = hashOps.get("test:1:base", "name");
        System.out.println("name = " + name);

        Object cellNum = redisTemplate.opsForHash().get("user:1:base", "cellNum");
        System.out.println("cellNum = " + cellNum);

        return name.toString();
    }

}
