package com.ziniu.service.Interface;

import com.ziniu.domain.ZnUserBase;
import org.springframework.stereotype.Service;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/8 0008 16:15
 */
@Service
public interface IUserService {

    public ZnUserBase getUserById(int id);

    public ZnUserBase getUserByCondition(ZnUserBase znUserBase);

}