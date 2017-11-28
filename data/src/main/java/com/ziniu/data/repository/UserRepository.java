package com.ziniu.data.repository;

import com.ziniu.data.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @author 好事近 haoshijin@ziniuxiaozhu.com
 * @Date 2017/11/22 13:55
 */
public interface UserRepository extends MongoRepository<User, String> {
    User findByLoginName(String loginName);
}
