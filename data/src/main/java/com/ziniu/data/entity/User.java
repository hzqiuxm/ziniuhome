package com.ziniu.data.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Created by yeoman on 2017/11/6.
 */
@Document
public class User {
    @Id
    protected ObjectId id;
    protected String loginName;
    protected String showName;
    protected String Password;
    protected byte stage;
    protected List<String> Roles;   //一个用户拥有的角色用一个list数组保存
    protected Date gmtModfiy;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        id = id;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public byte getStage() {
        return stage;
    }

    public void setStage(byte stage) {
        this.stage = stage;
    }

    public List<String> getRoles() {
        return Roles;
    }

    public void setRoles(List<String> roles) {
        Roles = roles;
    }

    public Date getGmtModfiy() {
        return gmtModfiy;
    }

    public void setGmtModfiy(Date gmtModfiy) {
        this.gmtModfiy = gmtModfiy;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", showName='" + showName + '\'' +
                ", Password='" + Password + '\'' +
                ", stage=" + stage +
                ", Roles=" + Roles +
                ", gmtModfiy=" + gmtModfiy +
                '}';
    }
}
