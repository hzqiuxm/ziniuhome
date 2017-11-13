package com.ziniu.data.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by yeoman on 2017/11/6.
 */
@Document(collection = "User")
public class UserInfo extends User {
    protected String cellNum;
    protected byte sex;
    protected int age;
    protected String rank;
    protected int jc;       //节操
    protected Res avatar;

    public String getCellNum() {
        return cellNum;
    }

    public void setCellNum(String cellNum) {
        this.cellNum = cellNum;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getJc() {
        return jc;
    }

    public void setJc(int jc) {
        this.jc = jc;
    }

    public Res getAvatar() {
        return avatar;
    }

    public void setAvatar(Res avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", showName='" + showName + '\'' +
                ", Password='" + Password + '\'' +
                ", stage=" + stage +
                ", Roles=" + Roles +
                ", cellNum='" + cellNum + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", rank='" + rank + '\'' +
                ", jc=" + jc +
                ", avatar=" + avatar +
                ", gmtModfiy=" + gmtModfiy +
                '}';
    }
}
