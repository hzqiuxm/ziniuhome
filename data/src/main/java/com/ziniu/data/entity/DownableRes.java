package com.ziniu.data.entity;

/**
 * 可下载的资源
 * Created by yeoman on 2017/10/25.
 */
public class DownableRes extends FileRes {

    protected int downCnt;

    public int getDownCnt() {
        return downCnt;
    }

    public void setDownCnt(int downCnt) {
        this.downCnt = downCnt;
    }

    @Override
    public String toString() {
        return "Res{" +
                "bucket='" + bucket + '\'' +
                ", fileKey='" + fileKey + '\'' +
                ", url='" + url + '\'' +
                ", fsize=" + fsize +
                ", downCnt=" + downCnt +
                "} ";
    }
}
