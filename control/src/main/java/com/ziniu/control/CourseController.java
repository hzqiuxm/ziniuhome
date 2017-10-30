package com.ziniu.control;

import com.ziniu.control.form.CourseForm;
import com.ziniu.data.entity.Course;
import com.ziniu.data.repository.CourseRepository;
import com.ziniu.service.interfaces.ICourseService;
import com.ziziu.common.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
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
    @ResponseBody
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

    @GetMapping("/getInfo/{id}")
    @ResponseBody
    public ModelMap getInfo(@PathVariable String id){
        if (StringUtils.isEmpty(id)){
            return getFailResult(Const.ReturnCode.F_201, "参数错误");
        }
        Course course = courseRepository.findById(id);
        if(null != course){
            return getSuccessResult(courseService.setKey(course));
        }
        return getFailResult(Const.ReturnCode.F_301,"未查到课程信息");
    }

    @GetMapping("/getList")
    @ResponseBody
    public ModelMap getList(){
        return getSuccessResult(courseService.setKeys(courseRepository.findAll()));
    }

    @PostMapping("/uploadCover")
    @ResponseBody
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
}
