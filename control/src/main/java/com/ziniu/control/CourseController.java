package com.ziniu.control;

import com.ziniu.control.form.CourseForm;
import com.ziniu.data.entity.Course;
import com.ziniu.data.entity.CourseSignup;
import com.ziniu.data.entity.Signup;
import com.ziniu.data.repository.CourseRepository;
import com.ziniu.service.interfaces.ICourseService;
import com.ziziu.common.Const;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.Date;

/**
 * 课程管理
 * Created by yeoman on 2017/10/26.
 */
@RestController
@RequestMapping("/course")
public class CourseController extends BaseController {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ICourseService courseService;

    /**
     * 发布课程
     * @param form
     * @return
     */
    @PostMapping("/publish")
    public ModelMap publish(CourseForm form){
        if (null != form){
            if (StringUtils.isEmpty(form.getTitle()) || StringUtils.isEmpty(form.getDescrip())
                    || StringUtils.isEmpty(form.getAudience())){
                return getFailResult(Const.ReturnCode.F_201, "参数错误");
            }
            Course course = new Course();
            course.setTitle(form.getTitle());
            course.setDescrip(form.getDescrip());
            course.setLecturer(getLoginName());
            course.setLecturerName(getShowName());
            course.setAudience(form.getAudience());
            course.setRuleCode(Const.RuleConf.COURSE_PUBLISH);
            course.setStage(Const.CourseStage.PUBLISH);
            courseRepository.insert(course);
            return getSuccessResult();
        }
        return getFailResult(Const.ReturnCode.F_201);
    }

    /**
     * 根据ID获取课程信息
     * @param id
     * @return
     */
    @GetMapping("/getInfo/{id}")
    public ModelMap getInfo(@PathVariable String id){
        if (StringUtils.isEmpty(id)){
            return getFailResult(Const.ReturnCode.F_201, "参数错误");
        }
        Course course = courseService.getCourse(id);
        if(null != course){
            return getSuccessResult(courseService.setKey(course, course.getId().toString()));
        }
        return getFailResult(Const.ReturnCode.F_301,"未查到课程信息");
    }

    /**
     * 获取课程列表
     * @return
     */
    @RolesAllowed({"ROLE_USER"})
//    @RolesAllowed({"ROLE_ADMIN"})
    @GetMapping("/getList")
    public ModelMap getList(){
        return getSuccessResult(courseService.setKeys(courseService
                .getCourseListByLecturerOrStage(getLoginName(), Const.CourseStage.SIGNUP)));
    }

    /**
     * 更新封面
     * @param id
     * @param title
     * @param image
     * @return
     */
    @PostMapping("/uploadCover")
    public ModelMap uploadCover(String id, String title, String image){
        if(StringUtils.isEmpty(id) || StringUtils.isEmpty(title) || StringUtils.isEmpty(image)){
            return getFailResult(Const.ReturnCode.F_201, "参数错误");
        }
        if(image.length() > 349549){
            return getFailResult(Const.ReturnCode.F_206, "超出最大支持的大小");
        }
        String header ="data:image/jpeg;base64,";
        if(image.indexOf(header) != 0){
            return getFailResult(Const.ReturnCode.F_205, "数据解析失败");
        }
        image = image.substring(header.length());

        if(courseService.uploadCover(id, image)){
            return getSuccessResult();
        }
        return getFailResult(Const.ReturnCode.F_303, "系统保存失败");
    }

    /**
     * 更新课程
     * @param form
     * @return
     */
    @PostMapping("/update")
    public ModelMap update(CourseForm form) {
        if (null != form) {
            if (StringUtils.isEmpty(form.getId()) || StringUtils.isEmpty(form.getTitle())
                    || StringUtils.isEmpty(form.getDescrip())
                    || StringUtils.isEmpty(form.getAudience())) {
                return getFailResult(Const.ReturnCode.F_201, "参数错误");
            }
            ObjectId objectId = new ObjectId(form.getId());
            if(!courseRepository.exists(objectId)){
                getFailResult(Const.ReturnCode.F_301,"未查到课程信息");
            }
            Course course = new Course();
            course.setId(objectId);
            course.setTitle(form.getTitle());
            course.setDescrip(form.getDescrip());
            course.setAudience(form.getAudience());
            course.setGmtLecture(new Date(form.getGmtLecture()));
            course.setAddr(form.getAddr());
            if (courseService.updateOneByIdSelective(course))
                return getSuccessResult();
            return getFailResult(Const.ReturnCode.F_303, "系统保存失败");
        }
        return getFailResult(Const.ReturnCode.F_201);
    }

    /**
     * 报名
     * @param id
     * @return
     */
    @PostMapping("/signup")
    public ModelMap signup(String id) {
        if (StringUtils.isEmpty(id)){
            return getFailResult(Const.ReturnCode.F_201, "参数错误");
        }
        CourseSignup courseSignup = courseService.getCourseSignup(id);
        if (null == courseSignup){
            return getFailResult(Const.ReturnCode.F_301,"未查到课程信息");
        }
        String curLoginEmail = getLoginName();
        if (courseSignup.getLecturer().equals(curLoginEmail) || courseSignup.getStage() != Const.CourseStage.SIGNUP){
            return getFailResult(Const.ReturnCode.F_203,"不支持该操作");
        }
        ArrayList<Signup> signups = courseSignup.getSignups();
        if (null != signups){
            for (Signup su : signups){
                if (su.getLoginName().equals(curLoginEmail)){
                    return getFailResult(Const.ReturnCode.F_204, "你已报名，请直接参与。");
                }
            }
        }

        if (courseService.signup(courseSignup.getId(), signups, curLoginEmail, getShowName()))
            return getSuccessResult();
        return getFailResult(Const.ReturnCode.F_303, "系统保存失败");
    }

    /**
     * 获取包括报名列表的课程信息
     * @param id
     * @return
     */
    @GetMapping("/getSignups/{id}")
    public ModelMap getSignups(@PathVariable String id){
        if (StringUtils.isEmpty(id)){
            return getFailResult(Const.ReturnCode.F_201, "参数错误");
        }
        Course courseSignup = courseRepository.findCourseSignupById(id);
        if (null == courseSignup){
            return getFailResult(Const.ReturnCode.F_301,"未查到课程信息");
        }
        return getSuccessResult(courseSignup);
    }
}
