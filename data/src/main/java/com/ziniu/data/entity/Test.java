package com.ziniu.data.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yeoman on 2017/10/18.
 */
public class Test implements Serializable {
    private String str;
    private int num;
    private long numLong;
    private byte b;
    private Date gmt;

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
                ", num=" + num +
                ", numLong=" + numLong +
                ", b=" + b +
                ", gmt=" + gmt +
                '}';
    }
}
