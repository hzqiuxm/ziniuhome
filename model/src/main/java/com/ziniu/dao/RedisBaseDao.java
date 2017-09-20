//package com.ziniu.dao;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//
//import javax.annotation.Resource;
//
///**
// * Copyright © 2016年 author. All rights reserved.
// *
// * @Author 临江仙 hzqiuxm@163.com
// * @Date 2017/9/20 0020 15:01
// */
//public abstract class RedisBaseDao {
//
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    @Resource(name="stringRedisTemplate")
//    ValueOperations<String,String> valueOpsStr;
//
//    @Autowired
//    RedisTemplate<Object,Object> objTp;
//
//    @Resource(name="redisTemplate")
//    ValueOperations<Object,Object> valOps;
//
//    HashOperations<String,String,String> hashOps;
//    /**
//     * 获取字符串型数据
//     * @param key
//     * @return
//     */
//    public String getString(String key){
//        return valueOpsStr.get(key);
//    }
//
//    public void delDb(String key){
//        return valOps.get(key).
//    }
//
//
//
//
//
//
//}
