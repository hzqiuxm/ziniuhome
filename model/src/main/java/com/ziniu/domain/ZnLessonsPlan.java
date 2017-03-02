package com.ziniu.domain;

import java.util.Date;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/1 0001 13:30
 */
public class ZnLessonsPlan {
    private Integer id;
    private String lessonName;
    private String lessonTitle;
    private String lessonDes;
    private Date lessonTime;
    private String lessonTeacher;
    private String lessonGrade;
    private Double lessonScore;
    private String lessonPlace;
    private Date createTime;
    private Date updateTime;
    private String state;
    private String notes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getLessonDes() {
        return lessonDes;
    }

    public void setLessonDes(String lessonDes) {
        this.lessonDes = lessonDes;
    }

    public Date getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(Date lessonTime) {
        this.lessonTime = lessonTime;
    }

    public String getLessonTeacher() {
        return lessonTeacher;
    }

    public void setLessonTeacher(String lessonTeacher) {
        this.lessonTeacher = lessonTeacher;
    }

    public String getLessonGrade() {
        return lessonGrade;
    }

    public void setLessonGrade(String lessonGrade) {
        this.lessonGrade = lessonGrade;
    }

    public Double getLessonScore() {
        return lessonScore;
    }

    public void setLessonScore(Double lessonScore) {
        this.lessonScore = lessonScore;
    }

    public String getLessonPlace() {
        return lessonPlace;
    }

    public void setLessonPlace(String lessonPlace) {
        this.lessonPlace = lessonPlace;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZnLessonsPlan that = (ZnLessonsPlan) o;

        if (id != that.id) return false;
        if (lessonName != null ? !lessonName.equals(that.lessonName) : that.lessonName != null) return false;
        if (lessonTitle != null ? !lessonTitle.equals(that.lessonTitle) : that.lessonTitle != null) return false;
        if (lessonDes != null ? !lessonDes.equals(that.lessonDes) : that.lessonDes != null) return false;
        if (lessonTime != null ? !lessonTime.equals(that.lessonTime) : that.lessonTime != null) return false;
        if (lessonTeacher != null ? !lessonTeacher.equals(that.lessonTeacher) : that.lessonTeacher != null)
            return false;
        if (lessonGrade != null ? !lessonGrade.equals(that.lessonGrade) : that.lessonGrade != null) return false;
        if (lessonScore != null ? !lessonScore.equals(that.lessonScore) : that.lessonScore != null) return false;
        if (lessonPlace != null ? !lessonPlace.equals(that.lessonPlace) : that.lessonPlace != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = id;
        result = 31 * result + (lessonName != null ? lessonName.hashCode() : 0);
        result = 31 * result + (lessonTitle != null ? lessonTitle.hashCode() : 0);
        result = 31 * result + (lessonDes != null ? lessonDes.hashCode() : 0);
        result = 31 * result + (lessonTime != null ? lessonTime.hashCode() : 0);
        result = 31 * result + (lessonTeacher != null ? lessonTeacher.hashCode() : 0);
        result = 31 * result + (lessonGrade != null ? lessonGrade.hashCode() : 0);
        result = 31 * result + (lessonScore != null ? lessonScore.hashCode() : 0);
        result = 31 * result + (lessonPlace != null ? lessonPlace.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
