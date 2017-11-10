package com.ziniu.data.entity;

/**
 * 资源类
 * Created by yeoman on 2017/10/20.
 */
public class Res {
    protected String bucket;
    protected String fileKey;
    protected String url;

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getFileKey() {
        return fileKey;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Res{" +
                "bucket='" + bucket + '\'' +
                ", fileKey='" + fileKey + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
