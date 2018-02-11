package com.ziziu.common.exception;

import com.ziziu.common.Const;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2018/2/9 10:38
 */
public class ParamCheckException extends ZiniuException {

    /**
     * 异常构造方法，code统一，msg根据验证结果返回
     *
     * @param msg  错误信息
     */
    public ParamCheckException(String msg) {
        super(Const.ParamCheck.PARAM_IVALID,msg);
    }
}
