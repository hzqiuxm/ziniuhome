package com.ziniu.data.entity;

/**
 * 文件资源
 * Created by yeoman on 2017/10/25.
 */
public class FileRes extends Res {

    protected int fsize;

    public int getFsize() {
        return fsize;
    }

    public void setFsize(int fsize) {
        this.fsize = fsize;
    }

    @Override
    public String toString() {
        return "Res{" +
                "bucket='" + bucket + '\'' +
                ", fileKey='" + fileKey + '\'' +
                ", url='" + url + '\'' +
                ", fsize=" + fsize +
                "} ";
    }
}
