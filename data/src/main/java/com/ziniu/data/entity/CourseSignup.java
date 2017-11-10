package com.ziniu.data.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/**
 * 课程报名类
 * Created by yeoman on 2017/10/25.
 */
@Document(collection = "course")
public class CourseSignup extends Course {

    protected ArrayList<Signup> signups;

    public ArrayList<Signup> getSignups() {
        return signups;
    }

    public void setSignups(ArrayList<Signup> signups) {
        this.signups = signups;
    }

    @Override
    public String toString() {
        return "CourseSignup{" +
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
                ", signups=" + signups +
                '}';
    }
}
