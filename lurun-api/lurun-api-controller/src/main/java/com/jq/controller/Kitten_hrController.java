package com.jq.controller;

import com.alibaba.fastjson.JSONObject;
import com.jq.dto.ResponseDTO;
import com.jq.pojo.*;
import com.jq.service.Kitten_hrService;
import com.jq.service.Kitten_userService;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequestMapping("/hr")
@Slf4j
@RestController
@ApiResponses({
        @ApiResponse(code = 200, message = "请求正常", response = ResponseDTO.class)
})

public class Kitten_hrController {
    @Resource
    private Kitten_hrService kittenHrService;

    @PostMapping("/getEmployeeInfo")
    @ApiOperation("获取员工信息")
    public ResponseDTO getEmployeeInfo(HrEmployee hrEmployee) {
        List<HrEmployee> hrEmployeeList = kittenHrService.getEmployeeInfo(hrEmployee);
        return new ResponseDTO(100, "查询成功", null, hrEmployeeList);
    }

    @PostMapping("/addEmployeeInfo")
    @ApiOperation("新增员工信息")
    public ResponseDTO addEmployeeInfo(HrEmployee hrEmployee) {
        int addCount = kittenHrService.addEmployeeInfo(hrEmployee);
        return new ResponseDTO(100, "新增成功", addCount, null);
    }

    @PostMapping("/editEmployeeInfo")
    @ApiOperation("修改员工信息")
    public ResponseDTO editEmployeeInfo(HrEmployee hrEmployee) {
        int editCount = kittenHrService.editEmployeeInfo(hrEmployee);
        return new ResponseDTO(100, "修改成功", editCount, null);
    }

    @PostMapping("/addApplyUser")
    @ApiOperation("提交账号申请")
    public ResponseDTO addApplyUser(ApplyUser applyUser) {
        try {
            int addCount = kittenHrService.addApplyUser(applyUser);
            return new ResponseDTO(100, "已提交申请", addCount, null);
        } catch (Exception ex) {
            if (ex.getMessage().contains("apply_user_un")){
            log.error("提交失败", ex.getMessage());
            return new ResponseDTO(100, "请勿重复提交申请！", null, null);}
            else return new ResponseDTO(100, "出现未知错误,请联系管理员", null, null);
        }
    }

    @PostMapping("/editHomePage")
    @ApiOperation("修改首页招聘信息")
    public ResponseDTO editHomePage(HrHomepage hrHomepage) {
        kittenHrService.editHomePage(hrHomepage);
        return new ResponseDTO(100, "修改成功", null, null);
    }

    @PostMapping("/getHomePage")
    @ApiOperation("获取首页招聘信息")
    public ResponseDTO getHomePage() {
        List<HrHomepage> hrHomepageList=kittenHrService.getHomePage();
        return new ResponseDTO(100, "查询成功", null, hrHomepageList);
    }

    @PostMapping("/getHrNewemp")
    @ApiOperation("获取招聘人信息")
    public ResponseDTO getHrNewemp(HrNewemp hrNewemp) {
        List<HrNewemp> hrNewempList=kittenHrService.getHrNewemp(hrNewemp);
        return new ResponseDTO(100, "查询成功", null, hrNewempList);
    }

    @PostMapping("/editHrNewemp")
    @ApiOperation("修改招聘人信息状态")
    public ResponseDTO editHrNewemp(HrNewemp hrNewemp) {
        kittenHrService.editHrNewemp(hrNewemp);
        return new ResponseDTO(100, "修改成功", null, null);
    }

    @PostMapping("/addHrNewemp")
    @ApiOperation("新增招聘人信息")
    public ResponseDTO addHrNewemp(HrNewemp hrNewemp) {
        int addCount=kittenHrService.addHrNewemp(hrNewemp);
        return new ResponseDTO(100, "已提交", addCount, null);
    }
}

