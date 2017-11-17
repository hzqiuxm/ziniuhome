package com.ziniu.control.security;

import com.ziniu.data.entity.User;
import com.ziniu.data.repository.UserInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @author shengwuyou
 * @data 2017/11/15 0015 14:17
 */

public class JwtUserService implements UserDetailsService{

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public JwtUserBase loadUserByUsername(String username) throws UsernameNotFoundException {
        //通过username去找对应的用户信息
        User user = userInfoRepository.findUserByLoginName(username);
        if(user == null){
            throw new UsernameNotFoundException("can not find loginName in database, please try again!");
        }
        System.out.println("用户:"+username+"，拥有的权限："+user.getRoles());
        JwtUserBase jwtUserBase = new JwtUserBase();
        BeanUtils.copyProperties(user,jwtUserBase);
        return jwtUserBase;
    }
}
