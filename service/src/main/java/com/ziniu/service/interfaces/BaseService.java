package com.ziniu.service.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 抽象出了几个通用方法
 * Created by yeoman on 2017/10/26.
 */
public interface BaseService<T> {

    /**
     * 默认实现的设置对象主键的方法
     * @param data
     * @param key
     * @return
     */
    default ModelMap setKey(T data, String key){
        ModelMap map = new ModelMap();
        map.put(key, data);
        return map;
    }

    /**
     * 默认实现的设置对象列表主键的方法
     * @param list
     * @param keys
     * @return
     */
    default ModelMap setKeys(List<T> list, List<String> keys){
        if (list == null || keys == null || (list.size() != keys.size()))
            return null;

        ModelMap map = new ModelMap();
        for (int i = 0; i < keys.size(); i++)
            map.put(keys.get(i), list.get(i));

        return map;
    }

}
