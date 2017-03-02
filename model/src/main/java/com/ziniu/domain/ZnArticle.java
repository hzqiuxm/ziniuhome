package com.ziniu.domain;

import java.sql.Timestamp;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/1 0001 13:30
 */
public class ZnArticle {
    private int id;
    private Integer pcategory;
    private Integer category;
    private String imgUrl;
    private String title;
    private String secondTitle;
    private String summary;
    private String content;
    private Timestamp postTime;
    private String author;
    private Integer commentCount;
    private Integer readCount;
    private Integer smCount;
    private Timestamp lastUpdateTime;
    private Integer accountId;
    private String accountName;
    private Integer lastAccountId;
    private String lastAccountName;
    private Integer relPersonId;
    private String relPersonName;
    private Integer relCompanyId;
    private String relCompanyName;
    private String notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPcategory() {
        return pcategory;
    }

    public void setPcategory(Integer pcategory) {
        this.pcategory = pcategory;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getSmCount() {
        return smCount;
    }

    public void setSmCount(Integer smCount) {
        this.smCount = smCount;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
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

    public Integer getLastAccountId() {
        return lastAccountId;
    }

    public void setLastAccountId(Integer lastAccountId) {
        this.lastAccountId = lastAccountId;
    }

    public String getLastAccountName() {
        return lastAccountName;
    }

    public void setLastAccountName(String lastAccountName) {
        this.lastAccountName = lastAccountName;
    }

    public Integer getRelPersonId() {
        return relPersonId;
    }

    public void setRelPersonId(Integer relPersonId) {
        this.relPersonId = relPersonId;
    }

    public String getRelPersonName() {
        return relPersonName;
    }

    public void setRelPersonName(String relPersonName) {
        this.relPersonName = relPersonName;
    }

    public Integer getRelCompanyId() {
        return relCompanyId;
    }

    public void setRelCompanyId(Integer relCompanyId) {
        this.relCompanyId = relCompanyId;
    }

    public String getRelCompanyName() {
        return relCompanyName;
    }

    public void setRelCompanyName(String relCompanyName) {
        this.relCompanyName = relCompanyName;
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

        ZnArticle znArticle = (ZnArticle) o;

        if (id != znArticle.id) return false;
        if (pcategory != null ? !pcategory.equals(znArticle.pcategory) : znArticle.pcategory != null) return false;
        if (category != null ? !category.equals(znArticle.category) : znArticle.category != null) return false;
        if (imgUrl != null ? !imgUrl.equals(znArticle.imgUrl) : znArticle.imgUrl != null) return false;
        if (title != null ? !title.equals(znArticle.title) : znArticle.title != null) return false;
        if (secondTitle != null ? !secondTitle.equals(znArticle.secondTitle) : znArticle.secondTitle != null)
            return false;
        if (summary != null ? !summary.equals(znArticle.summary) : znArticle.summary != null) return false;
        if (content != null ? !content.equals(znArticle.content) : znArticle.content != null) return false;
        if (postTime != null ? !postTime.equals(znArticle.postTime) : znArticle.postTime != null) return false;
        if (author != null ? !author.equals(znArticle.author) : znArticle.author != null) return false;
        if (commentCount != null ? !commentCount.equals(znArticle.commentCount) : znArticle.commentCount != null)
            return false;
        if (readCount != null ? !readCount.equals(znArticle.readCount) : znArticle.readCount != null) return false;
        if (smCount != null ? !smCount.equals(znArticle.smCount) : znArticle.smCount != null) return false;
        if (lastUpdateTime != null ? !lastUpdateTime.equals(znArticle.lastUpdateTime) : znArticle.lastUpdateTime != null)
            return false;
        if (accountId != null ? !accountId.equals(znArticle.accountId) : znArticle.accountId != null) return false;
        if (accountName != null ? !accountName.equals(znArticle.accountName) : znArticle.accountName != null)
            return false;
        if (lastAccountId != null ? !lastAccountId.equals(znArticle.lastAccountId) : znArticle.lastAccountId != null)
            return false;
        if (lastAccountName != null ? !lastAccountName.equals(znArticle.lastAccountName) : znArticle.lastAccountName != null)
            return false;
        if (relPersonId != null ? !relPersonId.equals(znArticle.relPersonId) : znArticle.relPersonId != null)
            return false;
        if (relPersonName != null ? !relPersonName.equals(znArticle.relPersonName) : znArticle.relPersonName != null)
            return false;
        if (relCompanyId != null ? !relCompanyId.equals(znArticle.relCompanyId) : znArticle.relCompanyId != null)
            return false;
        if (relCompanyName != null ? !relCompanyName.equals(znArticle.relCompanyName) : znArticle.relCompanyName != null)
            return false;
        if (notes != null ? !notes.equals(znArticle.notes) : znArticle.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (pcategory != null ? pcategory.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (secondTitle != null ? secondTitle.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (postTime != null ? postTime.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (commentCount != null ? commentCount.hashCode() : 0);
        result = 31 * result + (readCount != null ? readCount.hashCode() : 0);
        result = 31 * result + (smCount != null ? smCount.hashCode() : 0);
        result = 31 * result + (lastUpdateTime != null ? lastUpdateTime.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (accountName != null ? accountName.hashCode() : 0);
        result = 31 * result + (lastAccountId != null ? lastAccountId.hashCode() : 0);
        result = 31 * result + (lastAccountName != null ? lastAccountName.hashCode() : 0);
        result = 31 * result + (relPersonId != null ? relPersonId.hashCode() : 0);
        result = 31 * result + (relPersonName != null ? relPersonName.hashCode() : 0);
        result = 31 * result + (relCompanyId != null ? relCompanyId.hashCode() : 0);
        result = 31 * result + (relCompanyName != null ? relCompanyName.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
