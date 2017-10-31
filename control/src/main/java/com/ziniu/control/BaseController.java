package com.ziniu.control;

import com.ziziu.common.Const;
import org.springframework.ui.ModelMap;

/**
 * Created by yeoman on 2017/10/19.
 */
public class BaseController {

    public static final String SUCCESS = "success";
    public static final String CODE = "code";
    public static final String DATA = "data";
    public static final String MSG = "msg";

    /**
     * 获取当前用户的登录名
     * @return
     */
    String getLoginName(){
        String loginName = "haosj";//测试用，等圣无忧实现
        return loginName;
    }

    /**
     * 获取当前用户的显示名称
     * @return
     */
    String getShowName(){
        String showName = "好事近";//测试用，等圣无忧实现
        return showName;
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
}
