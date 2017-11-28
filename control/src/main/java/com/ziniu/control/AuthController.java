package com.ziniu.control;

import com.ziniu.control.security.JwtTokenUtil;
import com.ziniu.control.security.JwtUser;
import com.ziniu.data.entity.User;
import com.ziniu.service.interfaces.IUserService;
import com.ziziu.common.Const;
import com.ziziu.common.constants.ZiniuEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @author 好事近 haoshijin@ziniuxiaozhu.com
 * @Date 2017/11/22 20:03
 */
@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    @Value("${jwt.header}")
    private String header;
    @Value("${jwt.expiration}")
    private String expiration;
    @Value("${jwt.expirationTime}")
    private long expirationTime;

    private AuthenticationManager authenticationManager;
    private IUserService userService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public AuthController(AuthenticationManager authenticationManager,
                          IUserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ModelMap login(HttpServletResponse response, String loginName, String password){
        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)){
            return getFailResult(Const.ReturnCode.F_201, "参数错误");
        }
        UsernamePasswordAuthenticationToken upAuthToken = new UsernamePasswordAuthenticationToken(loginName, password);
        final Authentication authentication = authenticationManager.authenticate(upAuthToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
        response.addHeader(this.header, jwtTokenUtil.generateToken(jwtUser));
        response.addHeader(this.expiration, this.expirationTime*JwtTokenUtil.A_MINUTE + "");

        return getSuccessResult(userService.getUserNoPasswdByLoginName(loginName));
    }


    @PostMapping("/register")
    public ModelMap register(String loginName, String password, String showName){
        if (StringUtils.isEmpty(loginName) || loginName.length() < 4 || loginName.length() > 40){
            return getFailResult(Const.ReturnCode.F_201, "登录名不能为空，且长度不能小于4位或大于40位");
        }
        if(userService.exists(loginName)){
            return getFailResult(ZiniuEnum.LOGINNAME_ALERDY_EXIST.getKey(), ZiniuEnum.LOGINNAME_ALERDY_EXIST.getValue());
        }
        if (StringUtils.isEmpty(password) || password.length() < 6 || password.length() > 32){
            return getFailResult(Const.ReturnCode.F_201, "密码名不能为空，且长度不能小于6位或大于32位");
        }
        if (StringUtils.isEmpty(showName) || showName.length() > 6){
            return getFailResult(Const.ReturnCode.F_201, "登录名不能为空，且长度不能大于6位");
        }
        User user = new User();
        user.setLoginName(loginName);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));

        user.setShowName(showName);
        if (userService.addUser(user))
            return getSuccessResult();
        return getFailResult(ZiniuEnum.LOGINING_ERROR.getKey(), ZiniuEnum.LOGINING_ERROR.getValue());
    }
}
