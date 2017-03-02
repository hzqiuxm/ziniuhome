package com.ziniu.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.ziniu.domain.ZnLessonsPlan;

@Mapper
public interface ZnLessonsPlanDao {
    int insert(@Param("pojo") ZnLessonsPlan pojo);

    int insertSelective(@Param("pojo") ZnLessonsPlan pojo);

    int insertList(@Param("pojos") List<ZnLessonsPlan> pojo);

    int update(@Param("pojo") ZnLessonsPlan pojo);
}
