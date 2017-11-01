package com.ziniu.data.repository;


import com.mongodb.BasicDBObject;
import com.ziniu.data.entity.JwtUmUserBase;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface JwtUmUserBaseDao extends MongoRepository<JwtUmUserBase, String> {

    JwtUmUserBase findByLoginName(String loginName);

    JwtUmUserBase findById(String id);

    JwtUmUserBase findBy(BasicDBObject  queryId);

}
