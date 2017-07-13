package com.ziniu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.ziniu.domain.UmSecUserRole;

@Mapper
public interface UmSecUserRoleDao {
    int insert(@Param("pojo") UmSecUserRole pojo);

    int insertSelective(@Param("pojo") UmSecUserRole pojo);

    int insertList(@Param("pojos") List<UmSecUserRole> pojo);

    int update(@Param("pojo") UmSecUserRole pojo);

    UmSecUserRole findById(@Param("id")Integer id);

    List<UmSecUserRole> findByUserId(@Param("userId")Integer userId);


}
