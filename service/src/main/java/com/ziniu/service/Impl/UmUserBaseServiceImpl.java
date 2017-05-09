package com.ziniu.service.Impl;

import com.ziniu.domain.UmUserBase;
import com.ziniu.service.Interface.IUmUserBaseService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.ziniu.dao.UmUserBaseDao;

@Service
public class UmUserBaseServiceImpl implements IUmUserBaseService{

    @Resource
    private UmUserBaseDao umUserBaseDao;

    public int insert(UmUserBase pojo){
        return umUserBaseDao.insert(pojo);
    }

    public int insertSelective(UmUserBase pojo){
        return umUserBaseDao.insertSelective(pojo);
    }

    public int insertList(List<UmUserBase> pojos){
        return umUserBaseDao.insertList(pojos);
    }

    public int update(UmUserBase pojo){
        return umUserBaseDao.update(pojo);
    }

    @Override
    public UmUserBase findByUserName(String UserName) {
        return umUserBaseDao.findByUserName(UserName);
    }
}
