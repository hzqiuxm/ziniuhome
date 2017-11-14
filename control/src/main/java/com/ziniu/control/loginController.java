package com.ziniu.control;

import com.alibaba.fastjson.JSONObject;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ziniu.control.security.JwtUserBase;
import com.ziniu.control.security.jwtfilter.JwtTokenUtil;
import com.ziniu.data.repository.UserInfoRepository;
import com.ziziu.common.HttpUrlConnection;
import com.ziziu.common.constants.ZiniuEnum;
import org.apache.log4j.Logger;
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

@Controller
@EnableEncryptableProperties
@RequestMapping("login")
public class loginController extends BaseController{
    private Logger log = Logger.getLogger(loginController.class);

    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    UserInfoRepository userInfoRepository;
    @GetMapping("/view")
    public String login(){
        log.info("loginController ：进入到登陆页面 ！");
        return "index";
    }


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
        JSONObject result = JSONObject.parseObject(resultInfo);
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
