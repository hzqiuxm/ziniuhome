package com.ziniu.control.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @author 好事近 haoshijin@ziniuxiaozhu.com
 * @Date 2017/11/22 16:07
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Value("${jwt.header}")
    private String header;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String authToken = request.getHeader(this.header);
        log.info("token：" + authToken);
        if (!StringUtils.isEmpty(authToken) && !authToken.equals("null")) {
            JwtUser jwtUser = jwtTokenUtil.getJwtUserFromToken(authToken);
            if (null == jwtUser) {
                response.setStatus(401);
                response.getWriter().write("token has expired");
                return;
            }
            MyAuthenticationToken myAuthToken = new MyAuthenticationToken(jwtUser,
                    null, jwtUser.getAuthorities());
            myAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(myAuthToken);

            if (jwtTokenUtil.canTokenBeRefreshed(jwtUser.getExpiration())){
                response.addHeader(this.header, jwtTokenUtil.generateToken(jwtUser));
            }
        }

        filterChain.doFilter(request, response);
    }
}
