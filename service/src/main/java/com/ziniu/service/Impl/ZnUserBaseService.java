package com.ziniu.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ziniu.domain.ZnUserBase;
import com.ziniu.domain.ZnUserBaseDao;

@Service
public class ZnUserBaseService{

    @Resource
    private ZnUserBaseDao znUserBaseDao;

    public int insert(ZnUserBase pojo){
        return znUserBaseDao.insert(pojo);
    }

    public int insertSelective(ZnUserBase pojo){
        return znUserBaseDao.insertSelective(pojo);
    }

    public int insertList(List<ZnUserBase> pojos){
        return znUserBaseDao.insertList(pojos);
    }

    public int update(ZnUserBase pojo){
        return znUserBaseDao.update(pojo);
    }

    public List<ZnUserBase> getUser(String userName){
        return znUserBaseDao.findByUserName(userName);
    }
}
