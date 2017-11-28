package com.ziniu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Created by yeoman on 2017/11/6.
 */
@Document
public class User {
    @Id
    protected String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    protected String loginName;
    protected String showName;
    protected String password;
    protected byte stage;
    protected List<String> roles;   //一个用户拥有的角色用一个list数组保存
    protected Date gmtCreate;
    protected Date gmtModfiy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getStage() {
        return stage;
    }

    public void setStage(byte stage) {
        this.stage = stage;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
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
                ", password='" + password + '\'' +
                ", stage=" + stage +
                ", roles=" + roles +
                ", gmtCreate=" + gmtCreate +
                ", gmtModfiy=" + gmtModfiy +
                '}';
    }
}
