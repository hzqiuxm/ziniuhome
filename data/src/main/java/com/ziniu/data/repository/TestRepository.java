package com.ziniu.data.repository;

import com.ziniu.data.entity.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by yeoman on 2017/10/19.
 */
public interface TestRepository extends MongoRepository<Test, String> {
}
