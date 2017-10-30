package com.ziniu.data.repository;

import com.ziniu.data.entity.Res;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;


/**
 * Created by yeoman on 2017/10/20.
 */
public interface ResRepository extends MongoRepository<Res, ObjectId> {

    Res findByFileKey(@Param("fileKey") String fileKey);

}
