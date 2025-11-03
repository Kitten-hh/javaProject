package com.jq.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户相关请求参数")
public class UserVO {
    @ApiModelProperty(value = "用户姓名")
    private String userName;
    @ApiModelProperty(value = "账号")
    private String userCode;
    @ApiModelProperty(value = "密码")
    private String userPassword;
    @ApiModelProperty(value = "当前页码",example = "1")
    private Integer page;
    @ApiModelProperty(value = "每页行数",example = "1")
    private Integer limit;
    @ApiModelProperty(value = "查询用户名")
    private String sname;
    @ApiModelProperty(value = "查询部门")
    private String sdep;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSdep() {
        return sdep;
    }

    public void setSdep(String sdep) {
        this.sdep = sdep;
    }
}
