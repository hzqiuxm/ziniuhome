package com.ziniu.service.Impl;

import com.ziniu.domain.ZnUserBase;
import com.ziniu.repository.ZnUserBaseRepository;
import com.ziniu.service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/8 0008 16:18
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    ZnUserBaseRepository znUserBaseRepository;

    @Override
    public ZnUserBase getUserById(int id) {

        return znUserBaseRepository.findOne(id);
    }

    @Override
    public ZnUserBase getUserByCondition(ZnUserBase znUserBase) {
        return znUserBaseRepository.findByuserName(znUserBase.getUserName());
    }


}
