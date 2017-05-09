package com.ziniu.domain;

import java.util.Date;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/7 0007 15:26
 */
public class UmSecRole {

    private Integer id;
    private String roleName;
    private String describer;
    private Integer status;
    private Date gmtCreate;
    private Date gmtModify;
    private Integer iExt;
    private String strExt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescriber() {
        return describer;
    }

    public void setDescriber(String describer) {
        this.describer = describer;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Integer getiExt() {
        return iExt;
    }

    public void setiExt(Integer iExt) {
        this.iExt = iExt;
    }

    public String getStrExt() {
        return strExt;
    }

    public void setStrExt(String strExt) {
        this.strExt = strExt;
    }
}
