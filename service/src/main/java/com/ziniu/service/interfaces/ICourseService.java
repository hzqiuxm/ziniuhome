package com.ziniu.service.interfaces;

import com.ziniu.data.entity.Course;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by yeoman on 2017/10/26.
 */
public interface ICourseService extends BaseService {

    ModelMap setKey(Course course);

    ModelMap setKeys(List<Course> list);

    boolean uploadCover(String id, String image);

}
