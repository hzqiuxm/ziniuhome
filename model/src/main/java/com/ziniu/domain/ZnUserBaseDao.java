package com.ziniu.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.ziniu.domain.ZnUserBase;
import org.springframework.stereotype.Repository;

@Mapper
public interface ZnUserBaseDao {
    int insert(@Param("pojo") ZnUserBase pojo);

    int insertSelective(@Param("pojo") ZnUserBase pojo);

    int insertList(@Param("pojos") List<ZnUserBase> pojo);

    int update(@Param("pojo") ZnUserBase pojo);

    List<ZnUserBase> findByUserName(@Param("userName")String userName);

    ZnUserBase findbyId(@Param("id")Integer id);
}
