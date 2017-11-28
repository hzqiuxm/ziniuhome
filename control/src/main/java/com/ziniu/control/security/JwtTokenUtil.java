package com.ziniu.control.security;

import com.ziniu.data.entity.User;
import com.ziniu.service.interfaces.IUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @author 好事近 haoshijin@ziniuxiaozhu.com
 * @Date 2017/11/22 11:07
 */
@Component
public class JwtTokenUtil implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);

    //一分钟( 60 X 1000 )
    public static final int A_MINUTE = 60000;
    public static final String SHOW_NAME = "showName";
    public static final String ROLES = "roles";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expirationTime}")
    private long expirationTime;

    @Value("${jwt.refresh}")
    private long refresh;

    private IUserService userService;

    private JwtTokenUtil(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        User user = userService.getUserByLoginName(loginName);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with loginName '%s'.", loginName));
        } else {
            return new JwtUser(user.getId(), user.getLoginName(), user.getPassword(),
                            user.getShowName(), user.getRoles(), null);
        }
    }

    //生成token
    public String generateToken(JwtUser jwtUser) {
        if (null == jwtUser){
            log.error("No successful login user");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put(Claims.ID, jwtUser.getId());
        claims.put(Claims.SUBJECT, jwtUser.getUsername());
        claims.put(SHOW_NAME, jwtUser.getShowName());
        claims.put(ROLES, jwtUser.getRoles());
        return this.EncAndDec(Jwts.builder()
                .setClaims(claims)
                .setExpiration(this.generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret) //采用什么算法是可以自己选择的，不一定非要采用HS512
                .compact(), Cipher.ENCRYPT_MODE);
    }

    public JwtUser getJwtUserFromToken(String token){
        Claims claims = getClaimsFromToken(this.EncAndDec(token, Cipher.DECRYPT_MODE));
        if (null == claims)
            return null;
        return new JwtUser(claims.getId(), claims.getSubject(),null,
                claims.get(SHOW_NAME).toString(),
                (ArrayList<String>)claims.get(ROLES), claims.getExpiration());
    }

    //解析token
    Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException eje) {
            log.error("凭证已过期");
            claims = null;
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expirationTime*A_MINUTE);
    }

    public boolean canTokenBeRefreshed(Date expirationDate) {
        return (expirationDate.getTime() - System.currentTimeMillis()) < (expirationTime - refresh)*A_MINUTE;
    }

    private String EncAndDec(String token, int mode){
        try {
            byte[] sourceBytes = token.getBytes("UTF-8");
            byte[] targetBytes;
            switch (mode){
                case Cipher.ENCRYPT_MODE:
                    targetBytes = Base64.encode(sourceBytes);
                    break;
                case Cipher.DECRYPT_MODE:
                    targetBytes = Base64.decode(sourceBytes);
                    break;
                default:
                    return null;
            }
            return new String(targetBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
