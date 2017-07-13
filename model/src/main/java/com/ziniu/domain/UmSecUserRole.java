package com.ziniu.domain;

import java.util.Date;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/7 0007 17:05
 */
public class UmSecUserRole {

    private Integer id;
    private Integer userId;
    private Integer roleId;
    private Date gmtCreate;
    private UmSecRole umSecRole;

    public UmSecRole getUmSecRole() {
        return umSecRole;
    }

    public void setUmSecRole(UmSecRole umSecRole) {
        this.umSecRole = umSecRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
