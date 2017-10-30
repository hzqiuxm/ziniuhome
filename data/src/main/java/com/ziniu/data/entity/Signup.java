package com.ziniu.data.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 报名类
 * Created by yeoman on 2017/10/19.
 */
public class Signup implements Serializable {

    protected String loginName;
    protected String showName;
    protected int rewardCnt;
    protected Date gmtSignup;

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

    public int getRewardCnt() {
        return rewardCnt;
    }

    public void setRewardCnt(int rewardCnt) {
        this.rewardCnt = rewardCnt;
    }

    public Date getGmtSignup() {
        return gmtSignup;
    }

    public void setGmtSignup(Date gmtSignup) {
        this.gmtSignup = gmtSignup;
    }

    @Override
    public String toString() {
        return "Signup{" +
                "loginName='" + loginName + '\'' +
                ", showName='" + showName + '\'' +
                ", rewardCnt=" + rewardCnt +
                ", gmtSignup=" + gmtSignup +
                '}';
    }
}
