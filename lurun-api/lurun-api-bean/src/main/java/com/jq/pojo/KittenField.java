package com.jq.pojo;

public class KittenField {
    private Integer f_id;

    private String code;

    private String value_chi;

    private String value_eng;

    private String sequence;

    public Integer getF_id() {
        return f_id;
    }

    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getValue_chi() {
        return value_chi;
    }

    public void setValue_chi(String value_chi) {
        this.value_chi = value_chi == null ? null : value_chi.trim();
    }

    public String getValue_eng() {
        return value_eng;
    }

    public void setValue_eng(String value_eng) {
        this.value_eng = value_eng == null ? null : value_eng.trim();
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence == null ? null : sequence.trim();
    }
}