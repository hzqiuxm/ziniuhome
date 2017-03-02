package com.ziniu.domain;

import java.sql.Timestamp;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/1 0001 13:30
 */
public class ZnLessons {
    private int id;
    private String lessonName;
    private String lessonType;
    private String lessonDes;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String isCycle;
    private String state;
    private String notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public String getLessonDes() {
        return lessonDes;
    }

    public void setLessonDes(String lessonDes) {
        this.lessonDes = lessonDes;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsCycle() {
        return isCycle;
    }

    public void setIsCycle(String isCycle) {
        this.isCycle = isCycle;
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

        ZnLessons znLessons = (ZnLessons) o;

        if (id != znLessons.id) return false;
        if (lessonName != null ? !lessonName.equals(znLessons.lessonName) : znLessons.lessonName != null) return false;
        if (lessonType != null ? !lessonType.equals(znLessons.lessonType) : znLessons.lessonType != null) return false;
        if (lessonDes != null ? !lessonDes.equals(znLessons.lessonDes) : znLessons.lessonDes != null) return false;
        if (createTime != null ? !createTime.equals(znLessons.createTime) : znLessons.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(znLessons.updateTime) : znLessons.updateTime != null) return false;
        if (isCycle != null ? !isCycle.equals(znLessons.isCycle) : znLessons.isCycle != null) return false;
        if (state != null ? !state.equals(znLessons.state) : znLessons.state != null) return false;
        if (notes != null ? !notes.equals(znLessons.notes) : znLessons.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lessonName != null ? lessonName.hashCode() : 0);
        result = 31 * result + (lessonType != null ? lessonType.hashCode() : 0);
        result = 31 * result + (lessonDes != null ? lessonDes.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (isCycle != null ? isCycle.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
