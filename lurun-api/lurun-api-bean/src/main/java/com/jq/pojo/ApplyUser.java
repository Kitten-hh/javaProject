package com.jq.pojo;

import java.sql.Date;

public class ApplyUser {
    private Integer id;

    private String applicant_name;

    private Date apply_date;

    private String user_name;

    private String user_workNum;

    private String apply_type;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name == null ? null : applicant_name.trim();
    }

    public Date getApply_date() {
        return apply_date;
    }

    public void setApply_date(Date apply_date) {
        this.apply_date = apply_date;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getUser_workNum() {
        return user_workNum;
    }

    public void setUser_workNum(String user_workNum) {
        this.user_workNum = user_workNum == null ? null : user_workNum.trim();
    }

    public String getApply_type() {
        return apply_type;
    }

    public void setApply_type(String apply_type) {
        this.apply_type = apply_type == null ? null : apply_type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}