package com.ziniu.control;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ziniu.control.security.jwtfilter.JwtTokenUtil;
import com.ziniu.data.entity.User;
import com.ziniu.data.repository.UserRepository;
import com.ziniu.service.interfaces.IUserBaseService;
import com.ziziu.common.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @author shengwuyou
 * @data 2017/11/15 0015 14:17
 */


@Controller
@RequestMapping("/user")
@EnableEncryptableProperties
public class UserController extends BaseController{
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    IUserBaseService userBaseService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    //@PostMapping("/register")
    //@ResponseBody
    //public ModelMap registerUser(String userInfo){
    //    //userInfo 可以是一个json  包含用户的username  password  phone  roles
    //    System.out.println(userInfo);
    //    if(userInfo==null||"".equals(userInfo)){
    //        return getFailResult(ZiniuEnum.USERINFO_NULL.getKey(),ZiniuEnum.USERINFO_NULL.getValue());
    //    }
    //    Map user = null;
    //    try {
    //        user = (Map) JSONObject.parse(userInfo);
    //        userBaseService.addNewUser(user);
    //    } catch (Exception e){
    //        log.error("用户注册失败,userInfo的数据格式不正确！"+ e.getMessage());
    //        return getFailResult(ZiniuEnum.USERINFO_ERROR.getKey(),ZiniuEnum.USERINFO_ERROR.getValue());
    //    }
    //    return getSuccessResult();
    //}
    /**
     * 获取用户信息
     */
    //@RolesAllowed({"ROLE_USER"})
    //@ResponseBody
    //@RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    //public ModelMap getUserInfo(){
    //    JwtUserBase userDetails = (JwtUserBase) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    //    if(userDetails == null){
    //        return getFailResult(ZiniuEnum.USER_NO_LOGIN.getKey(),ZiniuEnum.USER_NO_LOGIN.getValue());
    //    }
    //    User user = new User();
    //    user.setShowName(userDetails.getShowName());
    //    user.setLoginName(userDetails.getLoginName());
    //    user.setRoles(userDetails.getRoles());
    //    return getSuccessResult(user);
    //}

    /**
     * 新用户注册
     * @param loginName
     * @param password
     * @param showName
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public ModelMap register(String loginName, String password, String showName){
        if (StringUtils.isEmpty(loginName) || loginName.length() < 4 || loginName.length() > 40){
            return getFailResult(Const.ReturnCode.F_201, "登录名不能为空，且长度不能小于4位或大于40位");
        }
        if(null != userRepository.findUserByLoginName(loginName)){
            return getFailResult(Const.ReturnCode.F_302, "用户已存在");
        }
        if (StringUtils.isEmpty(password) || password.length() < 6 || password.length() > 32){
            return getFailResult(Const.ReturnCode.F_201, "密码名不能为空，且长度不能小于6位或大于32位");
        }
        if (StringUtils.isEmpty(showName) || showName.length() > 6){
            return getFailResult(Const.ReturnCode.F_201, "登录名不能为空，且长度不能大于6位");
        }
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(password);
        user.setShowName(showName);
        user.setStage(Const.UserStage.STAGE_0);
        List<String> roles = new ArrayList<>();
        roles.add(0,"ROLE_USER");   //默认分配一个最基本的用户权限
        user.setRoles(roles);
        user.setGmtModfiy(new Date());
        userRepository.insert(user);
        log.info(user.toString());
        return getSuccessResult();
    }

    /**
     * 获取当前登录的用户信息
     * @return
     */
    @GetMapping("/getCurUser")
    @ResponseBody
    public ModelMap getCurUser(){
        return getSuccessResult(getJwtUserBase());
    }
}
