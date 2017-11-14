package com.ziniu.service.impl;

import com.mongodb.WriteResult;
import com.qiniu.storage.model.FileInfo;
import com.ziniu.data.entity.Course;
import com.ziniu.data.entity.CourseSignup;
import com.ziniu.data.entity.Res;
import com.ziniu.data.entity.Signup;
import com.ziniu.data.repository.CourseRepository;
import com.ziniu.service.interfaces.ICourseService;
import com.ziziu.common.Const;
import com.ziziu.common.QiniuFileUtil;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yeoman on 2017/10/26.
 */
@Service
public class CourseServImpl implements ICourseService {

    private static final Logger log = LoggerFactory.getLogger(CourseServImpl.class);
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course getCourse(String id) {
        if (StringUtils.isEmpty(id)){
            return null;
        }
        return courseRepository.findById(id);
    }

    @Override
    public CourseSignup getCourseSignup(String id) {
        if (StringUtils.isEmpty(id)){
            return null;
        }
        return (CourseSignup) courseRepository.findById(id);
    }

    @Override
    public List<Course> getCourseListByLecturerOrStage(String lecturer, byte stage) {
        return courseRepository.findAllByLecturerOrStage(lecturer, stage);
    }

    @Override
    public ModelMap setKeys(List<Course> list) {
        if(list == null)
            return null;

        ModelMap map = new ModelMap();
        for (Course course : list)
            map.put(course.getId().toString(), course);

        return map;
    }

    @Override
    public boolean uploadCover(String id, String image) {
        Course course = courseRepository.findById(id);
        if (course == null)
            return false;
        Res cover;
        if (course.getCover() != null){
            cover = course.getCover();
            //更新，先删除之前上传的。
            QiniuFileUtil.deleteImg(QiniuFileUtil.BUCKET, cover.getFileKey());
        }else {
            cover = new Res();
            cover.setBucket(QiniuFileUtil.BUCKET);
            cover.setFileKey(QiniuFileUtil.DIR_IMG + Const.ResDir.COURSE_COVER + course.getTitle());
            cover.setUrl(QiniuFileUtil.DOMAIN + cover.getFileKey());
            //更新状态为审核中
            course.setStage(Const.CourseStage.REVIEW);
        }
        FileInfo fileInfo = QiniuFileUtil.putImgRetInfo(QiniuFileUtil.BUCKET, cover.getFileKey(),
                Base64Utils.decodeFromString(image));
        if (fileInfo == null){
            return false;
        }
        course.setCover(cover);
        courseRepository.save(course);
        return true;
    }

    @Override
    public boolean update(Course course) {
        if (null == course){
            return false;
        }


        course.setGmtModify(new Date());
        courseRepository.save(course);
        return true;
    }

    @Override
    public boolean updateOneByIdSelective(Course course) {
        Query query = new Query(Criteria.where("id").is(course.getId()));
        Update update = new Update();
        if (!StringUtils.isEmpty(course.getTitle()))
            update.set("title", course.getTitle());
        if (!StringUtils.isEmpty(course.getDescrip()))
            update.set("descrip", course.getDescrip());
        if (!StringUtils.isEmpty(course.getLecturer()))
            update.set("lecturer", course.getLecturer());
        if (!StringUtils.isEmpty(course.getLecturerName()))
            update.set("lecturerName", course.getLecturerName());
        if (!StringUtils.isEmpty(course.getAudience()))
            update.set("audience", course.getAudience());
        if (null != course.getGmtLecture())
            update.set("gmtLecture", course.getGmtLecture());
        if (!StringUtils.isEmpty(course.getAddr()))
            update.set("addr", course.getAddr());
        if (course.getStage() > 0)
            update.set("stage", course.getStage());
        if (!StringUtils.isEmpty(course.getRuleCode()))
            update.set("ruleCode", course.getRuleCode());
        if (null != course.getCover())
            update.set("cover", course.getCover());
        update.set("gmtModify", new Date());
        WriteResult writeResult;
        if (course instanceof CourseSignup) {
            CourseSignup courseSignup = (CourseSignup) course;
            if (null != courseSignup.getSignups()){
                update.set("signups", courseSignup.getSignups());
            }
        }
        writeResult = mongoTemplate.updateFirst(query, update, Course.class);
        return writeResult.getN() == 1;
    }

    @Override
    public List<Course> getReviewList() {
        return courseRepository.findAllByStage(Const.CourseStage.REVIEW);
    }

    @Override
    public boolean signup(ObjectId id, ArrayList<Signup> signups, String loginEmail, String showName) {
        CourseSignup courseSignup = new CourseSignup();
        courseSignup.setId(id);
        if (null == signups)
            signups= new ArrayList<>();

        Signup signup = new Signup();
        signup.setLoginName(loginEmail);
        signup.setShowName(showName);

        signups.add(signup);
        courseSignup.setSignups(signups);
        return this.updateOneByIdSelective(courseSignup);
    }
}
