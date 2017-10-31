package com.ziniu.data.repository;

import com.ziniu.data.entity.Course;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by yeoman on 2017/10/26.
 */
public interface CourseRepository extends MongoRepository<Course, ObjectId> {

    Course findById(@Param("id") String id);
}
