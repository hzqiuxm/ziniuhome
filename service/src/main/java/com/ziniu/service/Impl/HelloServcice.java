package com.ziniu.service.Impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/2/28 0028 15:21
 */
@Service
public class HelloServcice {

    Logger log = Logger.getLogger("HelloServcice");

    public String sayHello(){

        log.log(Level.INFO,()->" log is info");
        return " hello";
    }

    public static void main(String[] args) {

        Key key = MacProvider.generateKey();

        System.out.println("key: " + key);


        String compactJws = Jwts.builder().setSubject("hzqiuxm")
                .signWith(SignatureAlgorithm.HS512, key)
                .setExpiration(new Date(System.currentTimeMillis()+300000))
                .setHeaderParam("createtime",new Date())
                .compact();

        System.out.println("compactJws: " + compactJws);

//        MacProvider.generateKey();
        if(Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getBody().getSubject().equals("hzqiuxm"))
            System.out.println("is ok!");


    }



//    public String generateToken(Map<String,Object> claims){
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(generateExpirationDate())
//
//    }


    public final void testJws(){

        Key key = MacProvider.generateKey();
        String compactJws = Jwts.builder().setSubject("hzqiuxm")
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

        assert Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws)
                .getBody().getSubject().equals("hzqiuxm");
    }


}


