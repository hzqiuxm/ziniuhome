package com.ziniu.data.repository;

import com.ziniu.data.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author shengwuyou
 * @data 2017/11/8 0008 14:09
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findUserByLoginName( String loginName);

}
