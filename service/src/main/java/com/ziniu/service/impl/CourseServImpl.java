package com.ziniu.service.impl;

import com.qiniu.storage.model.FileInfo;
import com.ziniu.data.entity.Course;
import com.ziniu.data.entity.Res;
import com.ziniu.data.repository.CourseRepository;
import com.ziniu.service.interfaces.ICourseService;
import com.ziziu.common.Const;
import com.ziziu.common.QiniuFileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Base64Utils;

import java.util.List;

/**
 * Created by yeoman on 2017/10/26.
 */
@Service
public class CourseServImpl implements ICourseService {

    private static final Logger log = LoggerFactory.getLogger(CourseServImpl.class);
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public ModelMap setKey(Course course) {
        if (course == null)
            return null;

        ModelMap map = new ModelMap();
        map.put(course.getId().toString(), course);
        return map;
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
            cover.setFileKey(QiniuFileUtil.DIR_IMG + "cover/" + course.getTitle());
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
}
