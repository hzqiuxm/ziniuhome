package com.ziniu.domain;

import java.sql.Timestamp;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/1 0001 13:31
 */
public class ZnWeeklyReport {
    private int id;
    private String reportWriter;
    private String reportThisWeek;
    private String reportNextWeek;
    private String reportDifficulty;
    private Timestamp reportTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReportWriter() {
        return reportWriter;
    }

    public void setReportWriter(String reportWriter) {
        this.reportWriter = reportWriter;
    }

    public String getReportThisWeek() {
        return reportThisWeek;
    }

    public void setReportThisWeek(String reportThisWeek) {
        this.reportThisWeek = reportThisWeek;
    }

    public String getReportNextWeek() {
        return reportNextWeek;
    }

    public void setReportNextWeek(String reportNextWeek) {
        this.reportNextWeek = reportNextWeek;
    }

    public String getReportDifficulty() {
        return reportDifficulty;
    }

    public void setReportDifficulty(String reportDifficulty) {
        this.reportDifficulty = reportDifficulty;
    }

    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZnWeeklyReport that = (ZnWeeklyReport) o;

        if (id != that.id) return false;
        if (reportWriter != null ? !reportWriter.equals(that.reportWriter) : that.reportWriter != null) return false;
        if (reportThisWeek != null ? !reportThisWeek.equals(that.reportThisWeek) : that.reportThisWeek != null)
            return false;
        if (reportNextWeek != null ? !reportNextWeek.equals(that.reportNextWeek) : that.reportNextWeek != null)
            return false;
        if (reportDifficulty != null ? !reportDifficulty.equals(that.reportDifficulty) : that.reportDifficulty != null)
            return false;
        if (reportTime != null ? !reportTime.equals(that.reportTime) : that.reportTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (reportWriter != null ? reportWriter.hashCode() : 0);
        result = 31 * result + (reportThisWeek != null ? reportThisWeek.hashCode() : 0);
        result = 31 * result + (reportNextWeek != null ? reportNextWeek.hashCode() : 0);
        result = 31 * result + (reportDifficulty != null ? reportDifficulty.hashCode() : 0);
        result = 31 * result + (reportTime != null ? reportTime.hashCode() : 0);
        return result;
    }
}
