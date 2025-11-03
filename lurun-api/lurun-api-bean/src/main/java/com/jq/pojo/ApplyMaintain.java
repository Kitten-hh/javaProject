package com.jq.pojo;

import java.sql.Date;

public class ApplyMaintain {
    private Integer id;

    private String applicant_name;

    private Date apply_date;

    private String maintain_type;

    private String maintain_description;

    private String user_phone;

    private String location;

    private String detailed_location;

    private String leader;

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

    public String getMaintain_type() {
        return maintain_type;
    }

    public void setMaintain_type(String maintain_type) {
        this.maintain_type = maintain_type == null ? null : maintain_type.trim();
    }

    public String getMaintain_description() {
        return maintain_description;
    }

    public void setMaintain_description(String maintain_description) {
        this.maintain_description = maintain_description == null ? null : maintain_description.trim();
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone == null ? null : user_phone.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getDetailed_location() {
        return detailed_location;
    }

    public void setDetailed_location(String detailed_location) {
        this.detailed_location = detailed_location == null ? null : detailed_location.trim();
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}