package com.ziniu.domain;

import java.sql.Timestamp;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/1 0001 13:30
 */
public class ZnDiscuss {
    private int id;
    private Integer discussReportId;
    private String discussCritic;
    private String discussReply;
    private String discussMessage;
    private Timestamp discussTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getDiscussReportId() {
        return discussReportId;
    }

    public void setDiscussReportId(Integer discussReportId) {
        this.discussReportId = discussReportId;
    }

    public String getDiscussCritic() {
        return discussCritic;
    }

    public void setDiscussCritic(String discussCritic) {
        this.discussCritic = discussCritic;
    }

    public String getDiscussReply() {
        return discussReply;
    }

    public void setDiscussReply(String discussReply) {
        this.discussReply = discussReply;
    }

    public String getDiscussMessage() {
        return discussMessage;
    }

    public void setDiscussMessage(String discussMessage) {
        this.discussMessage = discussMessage;
    }

    public Timestamp getDiscussTime() {
        return discussTime;
    }

    public void setDiscussTime(Timestamp discussTime) {
        this.discussTime = discussTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZnDiscuss znDiscuss = (ZnDiscuss) o;

        if (id != znDiscuss.id) return false;
        if (discussReportId != null ? !discussReportId.equals(znDiscuss.discussReportId) : znDiscuss.discussReportId != null)
            return false;
        if (discussCritic != null ? !discussCritic.equals(znDiscuss.discussCritic) : znDiscuss.discussCritic != null)
            return false;
        if (discussReply != null ? !discussReply.equals(znDiscuss.discussReply) : znDiscuss.discussReply != null)
            return false;
        if (discussMessage != null ? !discussMessage.equals(znDiscuss.discussMessage) : znDiscuss.discussMessage != null)
            return false;
        if (discussTime != null ? !discussTime.equals(znDiscuss.discussTime) : znDiscuss.discussTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (discussReportId != null ? discussReportId.hashCode() : 0);
        result = 31 * result + (discussCritic != null ? discussCritic.hashCode() : 0);
        result = 31 * result + (discussReply != null ? discussReply.hashCode() : 0);
        result = 31 * result + (discussMessage != null ? discussMessage.hashCode() : 0);
        result = 31 * result + (discussTime != null ? discussTime.hashCode() : 0);
        return result;
    }
}
