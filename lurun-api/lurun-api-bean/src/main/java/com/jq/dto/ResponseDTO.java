package com.jq.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 响应前端数据
 */
@ApiModel(value = "响应前端数据")
public class ResponseDTO {
    @ApiModelProperty(value = "响应编码:0:渲染列表,100:请求成功,101:请求失败,102:未认证,103:请求异常")
    private Integer code;
    @ApiModelProperty(value = "描述信息")
    private String msg;
    @ApiModelProperty(value = "返回数据")
    private Object data;
    @ApiModelProperty(value = "返回数据数量")
    private Integer count;

    /**
     * 响应数据
     * @param code 响应编码
     *             <br/>100:请求成功
     *             <br/>101:请求失败
     *             <br/>102:未认证
     *             <br/>103:请求异常
     *             <br/>0:渲染表格
     * @param msg 描述信息
     * @param data 响应的数据内容
     * @param count 响应数据行数
     */
    public ResponseDTO(Integer code, String msg, Integer count, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
