package com.ziziu.common.exception;


/**
 * @author shengwuyou
 * @data 2017/11/13 0013 19:07
 */

public class ZNUserException extends ZiniuException{
    /**
     * 异常构造方法，必须有Code和msg
     *
     * @param code 状态码
     * @param msg  错误信息
     */
    public ZNUserException(int code, String msg) {
        super(code, msg);
    }
}
