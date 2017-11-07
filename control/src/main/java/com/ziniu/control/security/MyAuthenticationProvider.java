package com.ziniu.control.security;

import com.ziniu.data.entity.JwtUmUserBase;
import com.ziniu.service.interfaces.IJwtUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class MyAuthenticationProvider implements AuthenticationProvider {
    private Logger log = Logger.getLogger(MyAuthenticationProvider.class);
    @Autowired
    private IJwtUserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String loginName = authentication.getName();
        String password = (String)authentication.getCredentials();
        log.error("loginName = "+loginName+" password = " +password);
        JwtUmUserBase userDetails = userService.loadUserByUsername(loginName);
        if (userDetails ==null){
            log.error("loginName is not found ! ");
            throw new BadCredentialsException("loginName is not found ! ");
        }
        System.out.println("登录的密码是："+ userDetails.getPassword());
        if (!password.equals(userDetails.getPassword())){
            log.error("password is wrong !  ");
            throw new BadCredentialsException("password is wrong ! ");
        }
        //用户对应的角色
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        return new UsernamePasswordAuthenticationToken(userDetails,password,authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
