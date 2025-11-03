package com.jq.pojo;

import java.sql.Date;

public class HrEmployee {
    private Integer id;

    private String registrant_name;

    private Date registrant_date;

    private String name;

    private String sex;

    private Date entryDate;

    private String workNum;

    private String department;

    private String job;

    private String phone;

    private String email;

    private String location;

    private String emp_status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistrant_name() {
        return registrant_name;
    }

    public void setRegistrant_name(String registrant_name) {
        this.registrant_name = registrant_name == null ? null : registrant_name.trim();
    }

    public Date getRegistrant_date() {
        return registrant_date;
    }

    public void setRegistrant_date(Date registrant_date) {
        this.registrant_date = registrant_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum == null ? null : workNum.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getEmp_status() {
        return emp_status;
    }

    public void setEmp_status(String emp_status) {
        this.emp_status = emp_status == null ? null : emp_status.trim();
    }
}