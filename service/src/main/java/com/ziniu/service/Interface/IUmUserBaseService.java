package com.ziniu.service.Interface;

import com.ziniu.domain.UmUserBase;

import java.util.List;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/7 0007 9:54
 */
public interface IUmUserBaseService {

    public int insert(UmUserBase pojo);

    public int insertSelective(UmUserBase pojo);

    public int insertList(List<UmUserBase> pojos);

    public int update(UmUserBase pojo);

    public UmUserBase findByUserName(String UserName);
}
