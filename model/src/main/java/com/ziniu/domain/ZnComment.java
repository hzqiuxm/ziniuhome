package com.ziniu.domain;

import java.sql.Timestamp;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/1 0001 13:30
 */
public class ZnComment {
    private int id;
    private String content;
    private Integer accountId;
    private String accountName;
    private Timestamp postTime;
    private Integer articleId;
    private Integer forId;
    private String notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getForId() {
        return forId;
    }

    public void setForId(Integer forId) {
        this.forId = forId;
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

        ZnComment znComment = (ZnComment) o;

        if (id != znComment.id) return false;
        if (content != null ? !content.equals(znComment.content) : znComment.content != null) return false;
        if (accountId != null ? !accountId.equals(znComment.accountId) : znComment.accountId != null) return false;
        if (accountName != null ? !accountName.equals(znComment.accountName) : znComment.accountName != null)
            return false;
        if (postTime != null ? !postTime.equals(znComment.postTime) : znComment.postTime != null) return false;
        if (articleId != null ? !articleId.equals(znComment.articleId) : znComment.articleId != null) return false;
        if (forId != null ? !forId.equals(znComment.forId) : znComment.forId != null) return false;
        if (notes != null ? !notes.equals(znComment.notes) : znComment.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (accountName != null ? accountName.hashCode() : 0);
        result = 31 * result + (postTime != null ? postTime.hashCode() : 0);
        result = 31 * result + (articleId != null ? articleId.hashCode() : 0);
        result = 31 * result + (forId != null ? forId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
