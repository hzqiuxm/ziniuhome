package com.ziniu.security;

import com.ziniu.domain.UmUserBase;
import com.ziniu.service.Impl.CustomUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/8 0008 21:17
 * AuthenticationProvider 提供用户UserDetails的具体验证方式，在这里可以自定义用户密码的加密、验证方式等等。
 */

public class ZnAuthenticationProvider implements AuthenticationProvider {

    private Logger log = Logger.getLogger(ZnAuthenticationProvider.class);

    @Autowired
    private CustomUserService userService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName = authentication.getName();
        String password = (String)authentication.getCredentials();

        log.error("userName = " + userName + " password = " + password);
        UmUserBase userDetails = (UmUserBase)userService.loadUserByUsername(userName);
        if(userDetails==null){
            log.error("userDetails is null! userName not found");
            throw new BadCredentialsException("Username not found.");
        }

        System.out.println(userDetails.getPassword());
        if(!password.equals(userDetails.getPassword())){
            log.error("Wrong password!");
            throw new BadCredentialsException("Wrong password.");
        }

        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        return new UsernamePasswordAuthenticationToken(userDetails,password,authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
