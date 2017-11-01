package com.ziniu.control;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ziniu.data.entity.JwtUmUserBase;
import com.ziniu.security.jwtFilter.JwtTokenUtil;
import com.ziniu.service.interfaces.IUserBaseService;
import com.ziziu.common.constants.ZiniuEnum;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@EnableEncryptableProperties
public class UserController extends BaseController{
    private Logger log =Logger.getLogger(UserController.class);

    @Autowired
    IUserBaseService userBaseService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/logn", method = RequestMethod.POST)
    public JwtUmUserBase lo(HttpServletRequest request) throws Exception{

        String token = request.getHeader("Authorization").substring(6);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUmUserBase jwtUmUserBase = userBaseService.findByUsername(username);
        return jwtUmUserBase;
    }

    // 只能admin权限能审批通过用户，post请求
//    @RolesAllowed("ROLE_ADMIN")

    @PostMapping("/register")
    @ResponseBody
    public ModelMap registerUser(String userInfo){
        //userInfo 可以是一个json  包含用户的username  password  phone  roles
        System.out.println(userInfo);
        if(userInfo==null||"".equals(userInfo)){
            return getFailResult(ZiniuEnum.USERINFO_NULL.getKey(),ZiniuEnum.USERINFO_NULL.getValue());
        }
        Map user = null;
        try {
            user = (Map) JSONObject.parse(userInfo);
            userBaseService.addNewUser(user);
        } catch (Exception e){
            log.error("用户注册失败,userInfo的数据格式不正确！");
            return getFailResult(ZiniuEnum.USERINFO_ERROR.getKey(),ZiniuEnum.USERINFO_ERROR.getValue());
        }
        return getSuccessResult();
    }
}
