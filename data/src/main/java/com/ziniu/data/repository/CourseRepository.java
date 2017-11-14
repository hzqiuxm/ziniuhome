package com.ziniu.data.repository;

import com.ziniu.data.entity.Course;
import com.ziniu.data.entity.CourseSignup;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by yeoman on 2017/10/26.
 */
public interface CourseRepository extends MongoRepository<Course, ObjectId> {

    Course findById(@Param("id") String id);

    List<Course> findAllByLecturerOrStage(@Param("lecturer") String lecturer, @Param("stage") byte stage);

    List<Course> findAllByStage(@Param("stage") byte stage);

    CourseSignup findCourseSignupById(@Param("id") String id);
}
