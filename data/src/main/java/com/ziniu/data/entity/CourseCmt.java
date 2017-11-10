package com.ziniu.data.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * 课程评论类
 * Created by yeoman on 2017/10/19.
 */
@Document
public class CourseCmt {
    @Id
    protected ObjectId id;
    protected ObjectId courseId;
    protected String loginName;
    protected String showName;
    protected ObjectId cmtPid;
    protected List<String> likes;
    protected String content;
    protected Date gmtModify;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getCourseId() {
        return courseId;
    }

    public void setCourseId(ObjectId courseId) {
        this.courseId = courseId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public ObjectId getCmtPid() {
        return cmtPid;
    }

    public void setCmtPid(ObjectId cmtPid) {
        this.cmtPid = cmtPid;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    @Override
    public String toString() {
        return "CourseCmt{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", loginName='" + loginName + '\'' +
                ", showName='" + showName + '\'' +
                ", cmtPid=" + cmtPid +
                ", likes=" + likes +
                ", content='" + content + '\'' +
                ", gmtModify=" + gmtModify +
                '}';
    }
}
