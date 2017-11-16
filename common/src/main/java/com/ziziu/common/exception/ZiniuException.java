package com.ziziu.common.exception;

/**
 * @author shengwuyou
 * @data 2017/11/13 0013 18:30
 */

public abstract class ZiniuException extends Throwable{
    protected int code;
    protected String msg;
    /**
     * 异常构造方法，必须有Code和msg
     * @param code 状态码
     * @param msg  错误信息
     */

    public ZiniuException(int code, String msg){
        super();
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return code;
    }

    public String getMsg(){
        return this.msg;
    }
}
