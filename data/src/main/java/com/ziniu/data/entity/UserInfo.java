package com.ziniu.data.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by yeoman on 2017/11/6.
 */
@Document(collection = "user")
public class UserInfo extends User {
    protected byte sex;
    protected int age;
    protected String rank;
    protected String cellNum;
    protected int jc;       //节操
    protected String email;
    protected Res avatar;

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

    public String getCellNum() {
        return cellNum;
    }

    public void setCellNum(String cellNum) {
        this.cellNum = cellNum;
    }

    public int getJc() {
        return jc;
    }

    public void setJc(int jc) {
        this.jc = jc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", password='" + password + '\'' +
                ", stage=" + stage +
                ", roles=" + roles +
                ", sex=" + sex +
                ", age=" + age +
                ", rank='" + rank + '\'' +
                ", cellNum='" + cellNum + '\'' +
                ", jc=" + jc +
                ", email=" + email +
                ", avatar=" + avatar +
                ", gmtCreate=" + gmtCreate +
                ", gmtModfiy=" + gmtModfiy +
                '}';
    }
}
