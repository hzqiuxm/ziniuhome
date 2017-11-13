package com.ziniu.service.impl;


import com.ziniu.data.entity.Res;
import com.ziniu.data.entity.User;
import com.ziniu.data.entity.UserInfo;
import com.ziniu.data.repository.UserInfoRepository;
import com.ziniu.data.repository.UserRepository;
import com.ziniu.service.interfaces.IUserBaseService;
import com.ziziu.common.QiniuFileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserBaseServiceImpl implements IUserBaseService{

    @Autowired
    UserInfoRepository userInfoRepository;

    //注册用户
    @Override
    public void addNewUser(Map userInfo) throws Exception {
        //将用户信息添加到数据库中
        User user = new User();
        user.setLoginName((String) userInfo.get("loginName"));
        user.setPassword((String) userInfo.get("password"));
        Date date=new Date();
        user.setGmtModfiy(date);
        user.setShowName((String) userInfo.get("showName"));
        user.setStage((byte) 0);   //默认审核中

        List<String> roles = new ArrayList<>();
        roles.add(0,"ROLE_USER");   //默认分配一个最基本的用户权限
        user.setRoles(roles);

        UserInfo userInfo1 = new UserInfo();
        String age = (String) userInfo.get("age");
        userInfo1.setAge(Integer.parseInt(age));

        Res avatar= new Res();
        avatar.setBucket(QiniuFileUtil.BUCKET);
        avatar.setFileKey(QiniuFileUtil.DIR_IMG + "head/用户默认头像.png");
        avatar.setUrl(QiniuFileUtil.DOMAIN+avatar.getFileKey());    //

        userInfo1.setAvatar(avatar);
        userInfo1.setJc(0);   //默认一开始节操币为 0
        userInfo1.setRank((String) userInfo.get("rank"));
        userInfo1.setCellNum((String) userInfo.get("cellNumber"));

        byte temp = 0;
        if ("男".equals((String) userInfo.get("sex"))){
            temp = 1;
        }
        userInfo1.setSex(temp);
        BeanUtils.copyProperties(user,userInfo1);
        userInfoRepository.insert(userInfo1);
    }

    @Override
    public UserInfo findByUsername(String username) throws Exception {
        return null;//userDao.findByUserName(username);
    }
}