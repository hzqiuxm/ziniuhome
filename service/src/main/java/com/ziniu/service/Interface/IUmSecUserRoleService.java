package com.ziniu.service.Interface;

import com.ziniu.domain.UmSecUserRole;

import java.util.List;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/7 0007 17:19
 */
public interface IUmSecUserRoleService {

    public int insert(UmSecUserRole pojo);

    public int insertSelective(UmSecUserRole pojo);

    public int insertList(List<UmSecUserRole> pojos);

    public int update(UmSecUserRole pojo);
}
