package com.ziniu.repository;

import com.ziniu.domain.ZnUserBase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/8 0008 16:12
 */
public interface ZnUserBaseRepository extends JpaRepository<ZnUserBase,Integer>{

    ZnUserBase findByuserName(String username);

}
