package com.ziniu.service.impl;

import com.ziniu.data.entity.JwtUmUserBase;
import com.ziniu.data.repository.JwtUmUserBaseDao;
import com.ziniu.service.interfaces.IJwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class JwtUserService implements IJwtUserService{

    @Autowired
    private JwtUmUserBaseDao jwtUmUserBaseDao;

    @Override
    public JwtUmUserBase loadUserByUsername(String username) throws UsernameNotFoundException {
        //通过username去找对应的用户信息
        JwtUmUserBase user = jwtUmUserBaseDao.findByLoginName(username);
        if(user == null){
            throw new UsernameNotFoundException("can not find loginName in database, please try again!");
        }
        System.out.println("用户:"+username+"，拥有的权限："+user.getRoles());
        return user;
    }
}
