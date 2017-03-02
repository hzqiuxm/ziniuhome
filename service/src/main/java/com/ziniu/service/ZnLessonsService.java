package com.ziniu.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ziniu.domain.ZnLessons;
import com.ziniu.domain.ZnLessonsDao;

@Service
public class ZnLessonsService{

    @Resource
    private ZnLessonsDao znLessonsDao;

    public int insert(ZnLessons pojo){
        return znLessonsDao.insert(pojo);
    }

    public int insertSelective(ZnLessons pojo){
        return znLessonsDao.insertSelective(pojo);
    }

    public int insertList(List<ZnLessons> pojos){
        return znLessonsDao.insertList(pojos);
    }

    public int update(ZnLessons pojo){
        return znLessonsDao.update(pojo);
    }
}
