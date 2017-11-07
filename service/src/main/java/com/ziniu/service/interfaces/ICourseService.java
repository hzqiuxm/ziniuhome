package com.ziniu.service.interfaces;

import com.ziniu.data.entity.Course;
import com.ziniu.data.entity.CourseSignup;
import com.ziniu.data.entity.Signup;
import org.bson.types.ObjectId;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeoman on 2017/10/26.
 */
public interface ICourseService extends BaseService {

    /**
     * 获取基本信息的课程
     * @param id
     * @return
     */
    Course getCourse(String id);

    /**
     * 获得有报名信息的课程
     * @param id
     * @return
     */
    CourseSignup getCourseSignup(String id);

    /**
     * 根据讲师或指定状态获取课程列表
     * @param lecturer
     * @param stage
     * @return
     */
    List<Course> getCourseListByLecturerOrStage(String lecturer, byte stage);

    /**
     * 批量设置课程主键
     * @param list
     * @return
     */
    ModelMap setKeys(List<Course> list);

    /**
     * 上传封面
     * @param id
     * @param image
     * @return
     */
    boolean uploadCover(String id, String image);

    /**
     * 整体更新
     * @param course
     * @return
     */
    boolean update(Course course);

    /**
     * 选择性更新
     * @param course
     * @return
     */
    boolean updateOneByIdSelective(Course course);

    /**
     * 获取待审核的课程
     * @return
     */
    List<Course> getReviewList();

    /**
     * 报名课程
     * @param signups
     * @param curLoginEmail
     * @param showName
     * @return
     */
    boolean signup(ObjectId id, ArrayList<Signup> signups, String curLoginEmail, String showName);
}
