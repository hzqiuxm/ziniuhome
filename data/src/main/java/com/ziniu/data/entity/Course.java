package com.ziniu.data.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 课程类
 * Created by yeoman on 2017/7/14.
 */
@Document
public class Course {
    @Id
    protected ObjectId id;
    protected String title;
    protected String descrip;
    protected String lecturer;
    protected String lecturerName;
    protected String audience;
    protected Date gmtLecture;
    protected String addr;
    protected byte stage;
    protected String ruleCode;
    protected Res cover;
    protected Date gmtModify;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public Date getGmtLecture() {
        return gmtLecture;
    }

    public void setGmtLecture(Date gmtLecture) {
        this.gmtLecture = gmtLecture;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public byte getStage() {
        return stage;
    }

    public void setStage(byte stage) {
        this.stage = stage;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public Res getCover() {
        return cover;
    }

    public void setCover(Res cover) {
        this.cover = cover;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descrip='" + descrip + '\'' +
                ", lecturer=" + lecturer +
                ", lecturerName='" + lecturerName + '\'' +
                ", audience='" + audience + '\'' +
                ", gmtLecture=" + gmtLecture +
                ", addr='" + addr + '\'' +
                ", stage=" + stage +
                ", ruleCode=" + ruleCode +
                ", cover=" + cover +
                ", gmtModify=" + gmtModify +
                '}';
    }
}
