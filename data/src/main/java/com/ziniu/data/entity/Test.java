package com.ziniu.data.entity;

import com.ziniu.data.customer_validata.CheckCase;
import com.ziziu.common.constants.CaseMode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yeoman on 2017/10/18.
 */
public class Test implements Serializable {
    @NotNull
    @CheckCase(value = CaseMode.UPPER)
    private String str;
    @Pattern(regexp = "^(.+)@(.+)$",message = "邮箱的格式不合法")
    private String email;
    @Min(value = 10,message = "你锁输入的数字最小值不能小于10!")
    private int num;
    private long numLong;
    private byte b;
    private Date gmt;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public long getNumLong() {
        return numLong;
    }

    public void setNumLong(long numLong) {
        this.numLong = numLong;
    }

    public byte getB() {
        return b;
    }

    public void setB(byte b) {
        this.b = b;
    }

    public Date getGmt() {
        return gmt;
    }

    public void setGmt(Date gmt) {
        this.gmt = gmt;
    }

    @Override
    public String toString() {
        return "Test{" +
                "str='" + str + '\'' +
                ", email='" + email + '\'' +
                ", num=" + num +
                ", numLong=" + numLong +
                ", b=" + b +
                ", gmt=" + gmt +
                '}';
    }
}
