package com.ziniu.control.security.jwtfilter;


import com.ziniu.control.security.JwtUserBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @author  临江仙 hxqiuxm@163.com
 * @Date 2017/3/1 0001 10:39
 */

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    private UserDetailsService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    //jwt.header对应的是保存header的名字
    @Value("${jwt.header}")
    private String tokenHeader;

    @Value(("${jwt.tokenHead}"))
    private String tokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //去拿请求头里面的token参数
        String authHeader = request.getHeader(this.tokenHeader);
        if (authHeader != null && authHeader.startsWith(tokenHead)){
            //如果token存在且 以 Bearer 开头 就开始JWT解析
            final String authToken = authHeader.substring(tokenHead.length());
            String username = jwtTokenUtil.getUsernameFromToken(authToken);

            logger.info("checking authentication for user:" + username);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                JwtUserBase userDetails = (JwtUserBase) this.userService.loadUserByUsername(username);
                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails( new WebAuthenticationDetailsSource().buildDetails(request) );

                    logger.info("authenticated user " + username + ", setting security context");

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
