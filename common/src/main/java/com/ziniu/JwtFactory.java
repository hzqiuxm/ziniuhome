package com.ziniu;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;
import java.util.Date;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/8 0008 15:59
 */
public class JwtFactory {

    private static JwtFactory instance = new JwtFactory();

    private JwtFactory() {
    }

    private static JwtFactory getInstance(){
        return instance;
    }

    /**
     * 默认生成由yunhetong颁发，用HS512签名算法生成的token
     * @return
     */
    public String getToken(Key key) throws Exception {

        if(null == key){
            throw new Exception("生成token的密钥不能为空！");
        }
        return Jwts.builder()
                .setSubject("yunhetong")
                .signWith(SignatureAlgorithm.HS512,key)
                .setExpiration(new Date(System.currentTimeMillis()+300000))
                .setHeaderParam("CreateTime",new Date())
                .compact();
    }


    /**
     *
     * @param key 私钥
     * @param subject 颁发主题
     * @param signAl 签名算法
     * @param expireTime 有效期
     * @return
     * @throws Exception
     */
    public  String getToken(Key key, String subject,SignatureAlgorithm signAl, int expireTime) throws Exception {

        if(null == subject || "" == subject){
            subject = "yunhetong";
        }

        if(null == signAl){
            signAl = SignatureAlgorithm.HS512;
        }

        if(expireTime<=0){
            throw new Exception("Token的有效期不能小于0！");
        }

        return Jwts.builder()
                .setSubject(subject)
                .signWith(signAl,key)
                .setExpiration(new Date(System.currentTimeMillis()+expireTime*60000))
                .compact();

    }



}
