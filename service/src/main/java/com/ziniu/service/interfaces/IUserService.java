package com.ziniu.service.interfaces;

import com.ziniu.data.entity.User;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @author 好事近 haoshijin@ziniuxiaozhu.com
 * @Date 2017/11/27 15:33
 */
public interface IUserService {
    /**
     * 根据登录名判断用户是否存在
     * @param loginName
     * @return
     */
    boolean exists(String loginName);

    /**
     * 根据登录名获取用户信息
     * @param loginName
     * @return
     */
    User getUserByLoginName(String loginName);

    /**
     * 根据登录名获取用户信息，不包括登录密码
     * @param loginName
     * @return
     */
    User getUserNoPasswdByLoginName(String loginName);

    /**
     * 新增用户
     * @param user
     * @return
     */
    boolean addUser(User user);
}
