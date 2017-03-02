package com.ziniu.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.ziniu.domain.ZnLessons;

@Mapper
public interface ZnLessonsDao {
    int insert(@Param("pojo") ZnLessons pojo);

    int insertSelective(@Param("pojo") ZnLessons pojo);

    int insertList(@Param("pojos") List<ZnLessons> pojo);

    int update(@Param("pojo") ZnLessons pojo);
}
