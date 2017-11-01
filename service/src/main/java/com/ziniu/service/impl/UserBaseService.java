package com.ziniu.service.impl;


import com.ziniu.data.entity.JwtUmUserBase;
import com.ziniu.data.entity.Res;
import com.ziniu.data.repository.JwtUmUserBaseDao;
import com.ziniu.service.interfaces.IUserBaseService;
import com.ziziu.common.Const;
import com.ziziu.common.QiniuFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserBaseService implements IUserBaseService{

    @Autowired
    JwtUmUserBaseDao jwtUmUserBaseDao;

    //注册用户
    @Override
    public void addNewUser(Map userInfo) throws Exception {
        //将用户信息添加到数据库中
        JwtUmUserBase jwtUmUserBase = new JwtUmUserBase();
        jwtUmUserBase.setLoginName((String) userInfo.get("loginName"));
        jwtUmUserBase.setPassword((String) userInfo.get("password"));
        String age = (String) userInfo.get("age");
        jwtUmUserBase.setAge(Integer.getInteger(age));

        Res avatar= new Res();
        avatar.setBucket(QiniuFileUtil.BUCKET);
        avatar.setFileKey(QiniuFileUtil.DIR_IMG + "head/用户默认头像.png");
        avatar.setUrl(QiniuFileUtil.DOMAIN+avatar.getFileKey());    //

        jwtUmUserBase.setAvatar(avatar);
        jwtUmUserBase.setJc(0);   //默认一开始节操币为 0
        jwtUmUserBase.setRank((String) userInfo.get("rank"));
        jwtUmUserBase.setCellNum((String) userInfo.get("cellNumber"));
        Date date=new Date();
        jwtUmUserBase.setGmtModfiy(date);
        jwtUmUserBase.setShowName((String) userInfo.get("showName"));
        byte temp = 0;
        if ("男".equals((String) userInfo.get("sex"))){
            temp = 1;
        }
        jwtUmUserBase.setSex(temp);
        jwtUmUserBase.setStage((byte) 0);   //默认审核中

        List<String> roles = new ArrayList<>();
        roles.add(0,"ROLE_USER");   //默认分配一个最基本的用户权限
        jwtUmUserBase.setRoles(roles);
        jwtUmUserBaseDao.insert(jwtUmUserBase);
    }

    @Override
    public JwtUmUserBase findByUsername(String username) throws Exception {
        return null;//jwtUmUserBaseDao.findByUserName(username);
    }
}