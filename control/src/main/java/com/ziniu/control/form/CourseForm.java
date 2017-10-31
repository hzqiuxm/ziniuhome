package com.ziniu.control.form;

/**
 * Created by yeoman on 2017/10/26.
 */
public class CourseForm {
    private String id;
    private String title;
    private String descrip;
    private String audience;
    protected Long ruleCode;
    private Long gmtLecture;
    private String addr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public Long getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(Long ruleCode) {
        this.ruleCode = ruleCode;
    }

    public Long getGmtLecture() {
        return gmtLecture;
    }

    public void setGmtLecture(Long gmtLecture) {
        this.gmtLecture = gmtLecture;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
