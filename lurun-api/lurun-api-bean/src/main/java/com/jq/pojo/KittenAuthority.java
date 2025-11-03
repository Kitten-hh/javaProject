package com.jq.pojo;

public class KittenAuthority {
    private Integer t_id;

    private String authority_name;

    private String authority_department;

    private String authority_description;

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getAuthority_name() {
        return authority_name;
    }

    public void setAuthority_name(String authority_name) {
        this.authority_name = authority_name == null ? null : authority_name.trim();
    }

    public String getAuthority_department() {
        return authority_department;
    }

    public void setAuthority_department(String authority_department) {
        this.authority_department = authority_department == null ? null : authority_department.trim();
    }

    public String getAuthority_description() {
        return authority_description;
    }

    public void setAuthority_description(String authority_description) {
        this.authority_description = authority_description == null ? null : authority_description.trim();
    }
}