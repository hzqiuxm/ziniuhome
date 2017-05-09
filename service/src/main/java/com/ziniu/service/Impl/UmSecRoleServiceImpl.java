package com.ziniu.service.Impl;

import com.ziniu.domain.UmSecRole;
import com.ziniu.service.Interface.IUmSecRoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.ziniu.dao.UmSecRoleDao;

@Service
public class UmSecRoleServiceImpl implements IUmSecRoleService{

    @Resource
    private UmSecRoleDao umSecRoleDao;

    public int insert(UmSecRole pojo){
        return umSecRoleDao.insert(pojo);
    }

    public int insertSelective(UmSecRole pojo){
        return umSecRoleDao.insertSelective(pojo);
    }

    public int insertList(List<UmSecRole> pojos){
        return umSecRoleDao.insertList(pojos);
    }

    public int update(UmSecRole pojo){
        return umSecRoleDao.update(pojo);
    }
}
