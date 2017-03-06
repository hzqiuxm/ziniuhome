package com.ziniu.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ziniu.domain.ZnLessonsPlan;
import com.ziniu.domain.ZnLessonsPlanDao;

@Service
public class ZnLessonsPlanService{

    @Resource
    private ZnLessonsPlanDao znLessonsPlanDao;

    public int insert(ZnLessonsPlan pojo){
        return znLessonsPlanDao.insert(pojo);
    }

    public int insertSelective(ZnLessonsPlan pojo){
        return znLessonsPlanDao.insertSelective(pojo);
    }

    public int insertList(List<ZnLessonsPlan> pojos){
        return znLessonsPlanDao.insertList(pojos);
    }

    public int update(ZnLessonsPlan pojo){
        return znLessonsPlanDao.update(pojo);
    }
}
