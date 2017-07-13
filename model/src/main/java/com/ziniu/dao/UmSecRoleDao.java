package com.ziniu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.ziniu.domain.UmSecRole;

@Mapper
public interface UmSecRoleDao {
    int insert(@Param("pojo") UmSecRole pojo);

    int insertSelective(@Param("pojo") UmSecRole pojo);

    int insertList(@Param("pojos") List<UmSecRole> pojo);

    int update(@Param("pojo") UmSecRole pojo);

     UmSecRole findById(@Param("id")Integer id);


}
