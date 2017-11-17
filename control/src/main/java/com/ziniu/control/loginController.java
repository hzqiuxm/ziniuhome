package com.ziniu.control;

import com.alibaba.fastjson.JSONObject;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ziniu.control.security.JwtUserBase;
import com.ziniu.control.security.jwtfilter.JwtTokenUtil;
import com.ziniu.data.repository.UserInfoRepository;
import com.ziziu.common.HttpUrlConnection;
import com.ziziu.common.constants.ZiniuEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @author shengwuyou
 * @data 2017/11/15 0015 14:17
 */


@Controller
@EnableEncryptableProperties
@RequestMapping("login")
public class loginController extends BaseController{
    private static final Logger log = LoggerFactory.getLogger(loginController.class);

    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    UserInfoRepository userInfoRepository;


    @PostMapping("/getToken")
    @ResponseBody
    public ModelMap getToken(@Param("loginName") String loginName, @Param("password") String password,
                             HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String,Object> userInfo = new HashMap();
        if (loginName==null||"".equals(loginName)||password==null||"".equals(password)){
            return getFailResult(ZiniuEnum.LOGINNAME_PASSWORD_NULL.getKey(),ZiniuEnum.LOGINNAME_PASSWORD_NULL.getValue());
        }
        userInfo.put("loginName",loginName);
        userInfo.put("password",password);
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+"/loginProcess";
        //发起登陆验证，使用security
        String  resultInfo = HttpUrlConnection.post(url,userInfo);
        //解决登陆系统异常，控制台打印异常，错误不明显的问题
        JSONObject result = null;
        try {
            result = JSONObject.parseObject(resultInfo);
        } catch (Exception e) {
            log.error("系统异常，检查登陆系统代码！");
            return getFailResult(ZiniuEnum.LOGINING_ERROR.getKey(),ZiniuEnum.LOGINING_ERROR.getValue());
        }
        if ("failure".equals(result.get("InfoType"))){
            return getFailResult(ZiniuEnum.LOGINNAME_PASSWORD_ERROR.getKey(),ZiniuEnum.LOGINNAME_PASSWORD_ERROR.getValue());
        }
        response.addHeader("token", result.getString("token"));
        return getSuccessResult();
    }


    @PermitAll
    @PostMapping(value = "/success")
    @ResponseBody
    public String success( HttpServletRequest request, HttpServletResponse response){
        log.error("loginController : 登陆成功！");
        JwtUserBase userDetails = (JwtUserBase) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String auth = jwtTokenUtil.generateToken(userDetails);
        JSONObject successInfo = new JSONObject();
        successInfo.put("InfoType","success");
        successInfo.put("token",auth);
        return  successInfo.toJSONString();
    }


    @PermitAll
    @PostMapping(value = "/failure")
    @ResponseBody
    public String failure( HttpServletRequest request, HttpServletResponse response){
        log.error("loginController : 登陆失败！");
        JSONObject failureInfo = new JSONObject();
        failureInfo.put("InfoType","failure");
        return  failureInfo.toJSONString();
    }
}
