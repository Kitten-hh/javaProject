package com.jq.controller;

import com.alibaba.fastjson.JSONObject;
import com.jq.dto.ResponseDTO;
import com.jq.pojo.*;
import com.jq.service.Kitten_allUserService;
import com.jq.service.Kitten_userService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RequestMapping("/allUser")
@RestController
@ApiResponses({
        @ApiResponse(code = 200, message = "请求正常", response = ResponseDTO.class)
})

public class Kitten_allUserController {
    @Resource
    private Kitten_allUserService kittenAllUserService;


    @PostMapping("/myAuthorityList")
    @ApiOperation("获取个人权限列表")
    public ResponseDTO myAuthorityList(String nameStr) {
        System.out.println(nameStr);
        String[] nameArr = nameStr.split(",");
        List<String> nameList = Arrays.asList(nameArr);
        System.out.println(nameList);
        List<KittenAuthority> myAuthorityList = kittenAllUserService.myAuthorityList(nameList);
        return new ResponseDTO(100, "查询成功", null, myAuthorityList);
    }

    @PostMapping("/addApplyAuthority")
    @ApiOperation("添加权限申请")
    public ResponseDTO addApplyAuthority(ApplyAuthority applyAuthority) {
        int addCount=kittenAllUserService.addApplyAuthority(applyAuthority);
        return new ResponseDTO(100, "提交成功", addCount, null);
    }

    @PostMapping("/getauthorityService")
    @ApiOperation("获取权限流程")
    public ResponseDTO getauthorityService(String userName,String selectType,Integer userType) {
//        userType, 0-无审核权限，1-有审核权限
        List<ApplyAuthority> applyAuthoritie=kittenAllUserService.getauthorityService(userName,selectType,userType);
        return new ResponseDTO(100, "查询成功", null, applyAuthoritie);
    }

    @PostMapping("/editauthorityService")
    @ApiOperation("修改审批权限流程")
    public ResponseDTO editauthorityService(Integer id ,String status) {
        int editCount=kittenAllUserService.editauthorityService(id,status);
        return new ResponseDTO(100, "修改成功", editCount, null);
    }

    @PostMapping("/countApplyAuthority")
    @ApiOperation("获取权限待审数量")
    public ResponseDTO countApplyAuthority() {
        int count =kittenAllUserService.countApplyAuthority();
        return new ResponseDTO(100, null, count, count);
    }

    @PostMapping("/addApplyMaintain")
    @ApiOperation("新增运维申请")
    public ResponseDTO addApplyMaintain(ApplyMaintain applyMaintain) {
        applyMaintain.setId(null);
        int addCount =kittenAllUserService.addApplyMaintain(applyMaintain);
        return new ResponseDTO(100, "提交成功", addCount, null);
    }

    @PostMapping("/getApplyMaintain")
    @ApiOperation("获取运维流程表")
    public ResponseDTO getApplyMaintain(ApplyMaintain applyMaintain) {
        List<ApplyMaintain> maintainList=kittenAllUserService.getApplyMaintain(applyMaintain);
        return new ResponseDTO(100, null, null, maintainList);
    }

    @PostMapping("/editApplyMaintain")
    @ApiOperation("编辑运维流程表")
    public ResponseDTO editApplyMaintain(ApplyMaintain applyMaintain,Integer type) {
        String msg;
       int editCount = kittenAllUserService.editApplyMaintain(applyMaintain,type);
       if (editCount==-1){
           msg="此流程已审核处理，不可进行修改";
       }else msg="修改成功";
        return new ResponseDTO(100, msg, editCount, null);
    }


    @PostMapping("/getApplyProperty")
    @ApiOperation("获取物业流程表")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO getApplyProperty(ApplyProperty applyProperty) {
        System.out.println(JSONObject.toJSONString(applyProperty));
        List<ApplyProperty> applyPropertyList = kittenAllUserService.getKittenPropertyList(applyProperty);
        return new ResponseDTO(100, "查询成功", null, applyPropertyList);
    }

    @PostMapping("/addApplyProperty")
    @ApiOperation("新增物业申请")
    public ResponseDTO addApplyProperty(ApplyProperty applyProperty) {
        applyProperty.setId(null);
        int addCount =kittenAllUserService.addApplyProperty(applyProperty);
        return new ResponseDTO(100, "提交成功", addCount, null);
    }

    @PostMapping("/editApplyProperty")
    @ApiOperation("编辑物业流程表")
    public ResponseDTO editApplyProperty(ApplyProperty applyProperty,Integer type) {
        String msg;
        int editCount = kittenAllUserService.editApplyProperty(applyProperty,type);
        if (editCount==-1){
            msg="此流程已审核处理，不可进行修改";
        }else msg="修改成功";
        return new ResponseDTO(100, msg, editCount, null);
    }

    @PostMapping("/getAddressBook")
    @ApiOperation("获取通讯录列表")
    public ResponseDTO getAddressBook(HrEmployee hrEmployee) {
        System.out.println(JSONObject.toJSONString(hrEmployee));
        List<HrEmployee> hrEmployeeList=kittenAllUserService.getAddressBook(hrEmployee);
        return new ResponseDTO(100, "修改成功", null, hrEmployeeList);
    }

}

