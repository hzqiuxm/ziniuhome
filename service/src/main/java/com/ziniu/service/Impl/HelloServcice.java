package com.ziniu.service.Impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;


/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/2/28 0028 15:21
 */
@Service
public class HelloServcice {

    public String sayHello(){

        return " hello";
    }

    public static void main(String[] args) {

        Key key = MacProvider.generateKey();
        String compactJws = Jwts.builder().setSubject("hzqiuxm")
                .signWith(SignatureAlgorithm.HS512, key)
                .setExpiration(new Date(System.currentTimeMillis()+300000))
                .setHeaderParam("createtime",new Date())
                .compact();

        System.out.println("compactJws: " + compactJws);


    }



//    public String generateToken(Map<String,Object> claims){
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(generateExpirationDate())
//
//    }


    @Test
    public final void testJws(){

        Key key = MacProvider.generateKey();
        String compactJws = Jwts.builder().setSubject("hzqiuxm")
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

        assert Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws)
                .getBody().getSubject().equals("hzqiuxm");
    }


}


