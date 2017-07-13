package com.ziniu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.ziniu.domain.UmUserBase;

@Mapper
public interface UmUserBaseDao {

    int insert(@Param("pojo") UmUserBase pojo);

    int insertSelective(@Param("pojo") UmUserBase pojo);

    int insertList(@Param("pojos") List<UmUserBase> pojo);

    int update(@Param("pojo") UmUserBase pojo);

    UmUserBase findByUserName(@Param("UserName")String UserName);



}
