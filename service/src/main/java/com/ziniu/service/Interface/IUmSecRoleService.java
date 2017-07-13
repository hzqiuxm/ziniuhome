package com.ziniu.service.Interface;

import com.ziniu.domain.UmSecRole;

import java.util.List;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/7 0007 15:33
 */
public interface IUmSecRoleService {

    public int insert(UmSecRole pojo);

    public int insertSelective(UmSecRole pojo);

    public int insertList(List<UmSecRole> pojos);

    public int update(UmSecRole pojo);
}
