package com.jq.controller;

import com.alibaba.fastjson.JSONObject;

import com.jq.dto.ResponseDTO;
import com.jq.pojo.*;
import com.jq.service.Kitten_userService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequestMapping("/kittenUser")
@RestController
@ApiResponses({
        @ApiResponse(code = 200, message = "请求正常", response = ResponseDTO.class)
})

public class Kitten_userController {
    @Resource
    private Kitten_userService kittenUserService;

    @PostMapping("/getFieldValueByTypeID")
    @ApiOperation("获取下拉框")
    public ResponseDTO getFieldValueByTypeID(String typeId) {
        System.out.println(typeId);
        List<Map<String, String>> fieldList = kittenUserService.getFieldValueByTypeID(typeId);
        return new ResponseDTO(100, "获取下拉框值成功", null, fieldList);
    }

    @PostMapping("/userinfo")
    @ApiOperation("获取个人信息")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO getUserinfo(KittenUser kittenUser) {
//        HrEmployee userinfo=new HrEmployee();
        Map<String, String> userinfo = kittenUserService.getUserinfo(kittenUser);
        return new ResponseDTO(100, "查询成功", null, userinfo);
    }

    @PostMapping("/kittenUserList")
    @ApiOperation("获取用户信息列表")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO getKittenUserList(KittenUser kittenUser) {
        List<KittenUser> kittenUserList = kittenUserService.getKittenUserList(kittenUser);
        return new ResponseDTO(100, "查询成功", null, kittenUserList);
    }

    @PostMapping("/delKittenUser")
    @ApiOperation("删除用户信息")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO delKittenUser(Long user_id) {
        System.out.println(user_id);
       int delCount=kittenUserService.delKittenUser(user_id);
        return new ResponseDTO(100, "删除成功", delCount, null);
    }

    @PostMapping("/editKittenUser")
    @ApiOperation("修改用户信息")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO editKittenUser(KittenUser kittenUser) {
        System.out.println(JSONObject.toJSONString(kittenUser));
        if (kittenUser.getUser_id()==null){
//            新增用户
            int addCount=kittenUserService.addKittenUser(kittenUser);
            return new ResponseDTO(100, "新增成功", addCount, null);
        }else {
//            编辑用户
            kittenUserService.editKittenUser(kittenUser);
            return new ResponseDTO(100, "修改成功", null, null);
        }
    }

    @PostMapping("/getKittenMemo")
    @ApiOperation("获取用户备忘录")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO getKittenMemo(String workNum) {
        KittenMemo kittenMemo=kittenUserService.getKittenMemo(workNum);
        return new ResponseDTO(100, "查询成功", null, kittenMemo);
    }

    @PostMapping("/editKittenMemo")
    @ApiOperation("修改用户备忘录")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO editKittenMemo(KittenMemo kittenMemo) {
        kittenUserService.editKittenMemo(kittenMemo);
        return new ResponseDTO(100, "修改成功", null, null);
    }


    @PostMapping("/getApplyUser")
    @ApiOperation("获取账号申请")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO getApplyUser(String selectType,String applicant_name) {
//        if (selectType != null&&selectType.equals("待审")){
//            selectType="0";
//        }else if (selectType != null&&selectType.equals("已审")){
//            selectType="1";
//        }else if (selectType != null&&selectType.equals("已驳回")){
//            selectType="-3";
//        }
        List<Map<String, String>> userList=kittenUserService.getApplyUser(selectType,applicant_name);
        return new ResponseDTO(100, "查询成功", null, userList);
    }

    @PostMapping("/editApplyUser")
    @ApiOperation("修改账号申请状态")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO editApplyUser(Integer id,String status) {
        System.out.println(id+status);
        int editCount =kittenUserService.editApplyUser(id,status);
        return new ResponseDTO(100, "审批成功", editCount, null);
    }

    @PostMapping("/countApplyUser")
    @ApiOperation("获取待审数量")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO countApplyUser(String applicant_name) {
        int count =kittenUserService.countApplyUser(applicant_name);
        return new ResponseDTO(100, null, count, count);
    }


    @PostMapping("/kittenAuthorityList")
    @ApiOperation("获取用户权限列表")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO getKittenAuthorityList(KittenAuthority kittenAuthority) {
        List<KittenAuthority> kittenUserList = kittenUserService.getKittenAuthorityList(kittenAuthority);
        return new ResponseDTO(100, "查询成功", null, kittenUserList);
    }

    @PostMapping("/addAuthority")
    @ApiOperation("新增权限")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO addAuthority(KittenAuthority kittenAuthority) {

        int addCount=kittenUserService.addAuthority(kittenAuthority);

        return new ResponseDTO(100, "新增成功", addCount, null);
    }

    @PostMapping("/delAuthority")
    @ApiOperation("删除权限")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO delAuthority(int t_id) {
        int delCount=kittenUserService.delAuthority(t_id);
        return new ResponseDTO(100, "删除成功", delCount, null);
    }
    @PostMapping("/editAuthority")
    @ApiOperation("编辑权限")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO editAuthority(KittenAuthority authority) {
        int editCount =kittenUserService.editAuthority(authority);
        return new ResponseDTO(100, "修改成功", editCount, null);
    }

    @PostMapping("/editAuthorityMember")
    @ApiOperation("编辑权限成员")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO editAuthorityMember(String member,int tid) {
        int editCount=kittenUserService.editAuthorityMember(member,tid);
        return new ResponseDTO(100, "新增成功", editCount, null);
    }

    @PostMapping("/getLeftUserList")
    @ApiOperation("获取左侧筛选框用户列表")
    // @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    public ResponseDTO getLeftUserList() {
        List<Map<Integer,String>> leftUserList=kittenUserService.getLeftUserList();
        return new ResponseDTO(100, "查询成功", null, leftUserList);
    }


    @PostMapping("/getKittenField")
    @ApiOperation("获取字段维护表")
    public ResponseDTO getKittenField(KittenField kittenField) {
        List<KittenField> list=kittenUserService.getKittenLield(kittenField);
        return new ResponseDTO(100, "查询成功", null, list);
    }

    @PostMapping("/addKittenField")
    @ApiOperation("新增字段")
    public ResponseDTO addKittenField(KittenField kittenField) {
        int count=kittenUserService.addKittenField(kittenField);
        return new ResponseDTO(100, "新增成功", count, null);
    }

    @PostMapping("/editKittenField")
    @ApiOperation("编辑字段")
    public ResponseDTO editKittenField(KittenField kittenField) {
        int count=kittenUserService.editKittenField(kittenField);
        return new ResponseDTO(100, "修改成功", count, null);
    }
    @PostMapping("/delKittenField")
    @ApiOperation("删除字段")
    public ResponseDTO delKittenField(Integer f_id) {
        System.out.println(JSONObject.toJSONString(f_id));
        int count=kittenUserService.delKittenField(f_id);
        return new ResponseDTO(100, "删除成功", count, null);
    }
}

