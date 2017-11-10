package com.ziniu.service.interfaces;

import com.ziniu.data.entity.User;

import java.util.Map;

public interface IUserBaseService {
    //注册用户，用户基本信息（userId自增 status 初始为审核 0 ）+ 用户的角色
    void addNewUser(Map userInfo) throws Exception;

    User findByUsername(String username)throws Exception;
}
