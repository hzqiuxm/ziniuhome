package com.ziniu.control;

import com.ziniu.control.security.JwtUser;
import com.ziniu.data.entity.User;
import com.ziziu.common.Const;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by yeoman on 2017/10/19.
 */
public class BaseController<T> {

    public static final String SUCCESS = "success";
    public static final String CODE = "code";
    public static final String DATA = "data";
    public static final String MSG = "msg";

    /**
     * 获取当前用户的登录名
     * @return
     */
    String getLoginName(){
        JwtUser userDetails = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userDetails == null){
            return null;
        }
        return userDetails.getLoginName();
    }

    /**
     * 获取当前用户的显示名称
     * @return
     */
    String getShowName(){
        JwtUser userDetails = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userDetails == null){
            return null;
        }
        return userDetails.getShowName();
    }

    /**
     * 获取当前用户的信息
     * @return
     */
    User getCurUser(){
        JwtUser jwtUserBase = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(jwtUserBase == null){
            return null;
        }
        User user = new User();
        user.setLoginName(jwtUserBase.getLoginName());
        user.setShowName(jwtUserBase.getShowName());
        user.setRoles(jwtUserBase.getRoles());
        return user;
    }

    ModelMap getSuccessResult(){
        ModelMap modelMap = new ModelMap();
        modelMap.put(SUCCESS, true);
        modelMap.put(CODE, Const.ReturnCode.OK);
        modelMap.put(MSG, "成功");
        return modelMap;
    }

    ModelMap getSuccessResult(Object data){
        ModelMap modelMap = getSuccessResult();
        modelMap.put(DATA, data);
        return modelMap;
    }

    ModelMap getSuccessResult(int failCode, String msg){
        ModelMap modelMap = new ModelMap();
        modelMap.put(SUCCESS, true);
        modelMap.put(CODE, failCode);
        modelMap.put(MSG, msg);
        return modelMap;
    }

    ModelMap getFailResult(int failCode){
        ModelMap modelMap = new ModelMap();
        modelMap.put(SUCCESS, false);
        modelMap.put(CODE, failCode);
        return modelMap;
    }

    ModelMap getFailResult(int failCode, Object data){
        ModelMap modelMap = getFailResult(failCode);
        modelMap.put(DATA, data);
        return modelMap;
    }

    ModelMap getFailResult(int failCode, String msg){
        ModelMap modelMap = getFailResult(failCode);
        modelMap.put(MSG, msg);
        return modelMap;
    }

    ModelMap getFailResult(int failCode, String msg, Object data){
        ModelMap modelMap = getFailResult(failCode, msg);
        modelMap.put(DATA, data);
        return modelMap;
    }

    /**
     * 默认实现的设置对象主键的方法
     * @param data
     * @param key
     * @return
     */
    ModelMap setKey(T data, String key){
        ModelMap map = new ModelMap();
        map.put(key, data);
        return map;
    }

    /**
     * 默认实现的设置对象列表主键的方法
     * @param list
     * @param keys
     * @return
     */
    ModelMap setKeys(List<T> list, List<String> keys){
        if (list == null || keys == null || (list.size() != keys.size()))
            return null;

        ModelMap map = new ModelMap();
        for (int i = 0; i < keys.size(); i++)
            map.put(keys.get(i), list.get(i));

        return map;
    }
}
