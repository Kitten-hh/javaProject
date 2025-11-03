package com.jq.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("密码请求参数")
public class PwdVO {
    @ApiModelProperty(value = "用户id",required = true)
    private Long uid;
    @ApiModelProperty(value = "用户密码",required = true)
    private String pwd;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
