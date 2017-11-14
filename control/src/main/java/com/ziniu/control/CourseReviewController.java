package com.ziniu.control;

import com.ziniu.data.entity.Course;
import com.ziniu.service.interfaces.ICourseService;
import com.ziziu.common.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Date;

/**
 * 课程审核
 * Created by yeoman on 2017/10/31.
 */
@RestController
public class CourseReviewController extends BaseController {

    @Autowired
    private ICourseService courseService;

    /**
     * 获取待审核的课程列表
     * @return
     */
    @GetMapping("/course/reviewList")
    @RolesAllowed({"ROLE_ADMIN"})
    public ModelMap reviewList(){
        return getSuccessResult(courseService.setKeys(courseService.getReviewList()));
    }

    /**
     * 审核课程
     * @param id
     * @param stage
     * @param gmtLecture
     * @param addr
     * @return
     */
    @PostMapping("/course/review")
    @RolesAllowed({"ROLE_ADMIN"})
    public ModelMap review(String id, Byte stage, Long gmtLecture, String addr) {
        if (StringUtils.isEmpty(id) || null == stage
                || (stage != Const.CourseStage.STAY && stage != Const.CourseStage.SIGNUP)){
            return getFailResult(Const.ReturnCode.F_201, "参数错误");
        }
        Course course = courseService.getCourse(id);
        if (null == course){
            return getFailResult(Const.ReturnCode.F_301,"未查到课程信息");
        }
        course.setStage(stage);
        if (null != gmtLecture && gmtLecture > 0) {
            course.setGmtLecture(new Date(gmtLecture));
        }
        if (!StringUtils.isEmpty(addr)) {
            course.setAddr(addr);
        }
        if (courseService.update(course))
            return getSuccessResult();
        return getFailResult(Const.ReturnCode.F_303, "系统保存失败");
    }
}
