package com.ziniu.service.impl;

import com.ziniu.data.entity.User;
import com.ziniu.data.repository.UserRepository;
import com.ziniu.service.interfaces.IUserService;
import com.ziziu.common.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @author 好事近 haoshijin@ziniuxiaozhu.com
 * @Date 2017/11/27 15:37
 */
@Service
public class UserServiceImpl implements IUserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean exists(String loginName) {
        return userRepository.exists(loginName);
    }

    @Override
    public User getUserByLoginName(String loginName) {
        return userRepository.findByLoginName(loginName);
    }

    @Override
    public User getUserNoPasswdByLoginName(String loginName) {
        User user = userRepository.findByLoginName(loginName);
        if (null == user)
            return null;
        user.setPassword(null);
        return user;
    }

    @Override
    public boolean addUser(User user) {
        user.setStage(Const.UserStage.STAGE_0);
        user.setRoles(Arrays.asList(Const.UserRoles.USER));
        user.setGmtCreate(new Date());
        user.setGmtModfiy(new Date());
        return userRepository.insert(user) != null;
    }
}
