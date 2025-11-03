package com.jq.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户登录请求参数")
public class LoginVO {
    @ApiModelProperty(value = "用户名",required = true,example = "sadmin")
    private String userCode;
    @ApiModelProperty(value = "密码",required = true,example = "SADMIN")
    private String userPassword;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
