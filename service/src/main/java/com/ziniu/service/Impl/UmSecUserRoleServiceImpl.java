package com.ziniu.service.Impl;

import com.ziniu.domain.UmSecUserRole;
import com.ziniu.service.Interface.IUmSecUserRoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.ziniu.dao.UmSecUserRoleDao;

@Service
public class UmSecUserRoleServiceImpl implements IUmSecUserRoleService{

    @Resource
    private UmSecUserRoleDao umSecUserRoleDao;

    public int insert(UmSecUserRole pojo){
        return umSecUserRoleDao.insert(pojo);
    }

    public int insertSelective(UmSecUserRole pojo){
        return umSecUserRoleDao.insertSelective(pojo);
    }

    public int insertList(List<UmSecUserRole> pojos){
        return umSecUserRoleDao.insertList(pojos);
    }

    public int update(UmSecUserRole pojo){
        return umSecUserRoleDao.update(pojo);
    }
}
