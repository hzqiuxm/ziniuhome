package com.ziniu.data.repository;

import com.ziniu.data.entity.User;
import com.ziniu.data.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author shengwuyou
 * @data 2017/11/8 0008 14:43
 */
public interface UserInfoRepository extends MongoRepository<UserInfo, String> {
    //
    User findUserByLoginName(@Param("loginName") String loginName);
    
}
