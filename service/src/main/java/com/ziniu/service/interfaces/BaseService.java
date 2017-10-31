package com.ziniu.service.interfaces;

import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 抽象出了几个通用方法
 * Created by yeoman on 2017/10/26.
 */
public interface BaseService<T> {

    default ModelMap setKey(T data, String key){
        ModelMap map = new ModelMap();
        map.put(key, data);
        return map;
    }

    default ModelMap setKeys(List<T> list, List<String> keys){
        if (list == null || keys == null || (list.size() != keys.size()))
            return null;

        ModelMap map = new ModelMap();
        for (int i = 0; i < keys.size(); i++)
            map.put(keys.get(i), list.get(i));

        return map;
    }
}
