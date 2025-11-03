package com.jq.controller;

import com.alibaba.fastjson.JSONObject;
import com.jq.dto.ResponseDTO;
import com.jq.pojo.KittenUser;
import com.jq.pojo.TJquser;
import com.jq.service.Kitten_userService;
import com.jq.service.UserService;
import com.jq.util.MD5;
import com.jq.vo.LoginVO;
import com.jq.vo.PwdVO;
import com.jq.vo.UserVO;
import io.swagger.annotations.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Api(value = "登录相关接口")
@ApiResponses({
        @ApiResponse(code = 100, message = "请求正常", response = ResponseDTO.class)
})
@Slf4j
@RestController
public class LoginController {

    @Resource
    private UserService userService;

    @Resource
    private Kitten_userService kittenUserService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @ApiOperation("条件查询用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true),
    })
    @GetMapping("/getUserList")
    public ResponseDTO getUserList(UserVO userVO) {
        //用户列表
        List<KittenUser> userList = userService.getUserList(userVO.getSname(), userVO.getSdep());
        //总条数
        int num = userService.getUserCount(userVO.getSname(), userVO.getSdep());
        return new ResponseDTO(0, "获取用户列表成功", num, userList);
    }

    @ApiOperation("更改用户状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true),
    })
    @PostMapping("/updateStatus")
    public ResponseDTO updateStatus(KittenUser kittenUser) {
        int num = userService.updateStatus(kittenUser.getUser_id(), kittenUser.getStatus());
        if (num > 0) {
            return new ResponseDTO(100, "更新状态成功", num, null);
        } else {
            return new ResponseDTO(101, "更新状态失败", 0, null);
        }
    }

    @ApiOperation(value = "重置密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true),
            @ApiImplicitParam(name = "uid", value = "用户id", required = true)
    })
    @PostMapping("/resetPwd")
    public ResponseDTO resetPwd(Long uid) {
        String czpwd = "111111";
        if (userService.updatePwd(uid, MD5.md5(czpwd),0) > 0) {
            return new ResponseDTO(100, "重置密码成功", 1, null);
        } else {
            return new ResponseDTO(101, "重置密码失败", 0, null);
        }
    }
    

    @ApiOperation("用户注销接口")
    @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    @PostMapping(value = "/logout")
    public ResponseDTO logout() {


            return new ResponseDTO(100, "已退出登录", null, null);
    }


    @ApiOperation(value = "获取用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true),
            @ApiImplicitParam(name = "uid", value = "用户id", required = true)
    })
    @PostMapping("/getUser")
    public ResponseDTO getUser(Long uid) {
        KittenUser user = userService.getUser(uid);
        if (user != null) {
            return new ResponseDTO(100, "获取用户成功", 1, user);
        } else {
            return new ResponseDTO(101, "获取用户失败", 0, null);
        }
    }


    @ApiOperation(value = "平台登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userCode", value = "用户名", required = true),
            @ApiImplicitParam(name = "userPassword", value = "用户密码", required = true)
    })
    @PostMapping(value = "/login")
    public ResponseDTO login(LoginVO loginVO) {

        String userCode = loginVO.getUserCode();
        String userPassword = loginVO.getUserPassword();

        String md5pwd = MD5.md5(userPassword);
        KittenUser kittenUser = userService.login(userCode, md5pwd);
            if (kittenUser != null) {
                String department=kittenUserService.getDepartment(kittenUser.getWorkNum());
                kittenUser.setDepartment(department);
                System.out.println(JSONObject.toJSONString(kittenUser));
                return new ResponseDTO(200, "登录成功", 1, kittenUser);
            } else {
                return new ResponseDTO(201, "账号或密码有误", 0, null);
            }
        }


    /**
     * 获取登录用户接口
     */
    @ApiOperation("获取登录用户接口")
    @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true)
    @GetMapping("/getLoginUser")
    public ResponseDTO getLoginUser(KittenUser kittenUser) {
        if (kittenUser.getWorkNum()==null){
            return new ResponseDTO(102, "登陆验证失败，请重新登录！", null, null);
        }else {
        KittenUser loginUser=kittenUserService.getLoginUser(kittenUser.getWorkNum());
        if(loginUser.getFirstLogin()==0){
            System.out.println(JSONObject.toJSONString(loginUser));
            return new ResponseDTO(201, "首次登录,请修改密码", null, loginUser);
        }
        return new ResponseDTO(200, "获取登录用户成功", null, loginUser);
    }}
    /*    *//**
     * 获取用户列表
     *//*



    /**
     * 进行MD5加密
     */
    @ApiOperation(value = "进行MD5加密")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token令牌", dataType = "string", paramType = "header", required = true),
            @ApiImplicitParam(name = "pwd", value = "密码", dataType = "string", required = true)
    })
    @PostMapping("/getMD5")
    public String getMD5(@RequestParam String pwd) {
        String md5Pwd = MD5.md5(pwd);
        System.out.println(md5Pwd);
        return md5Pwd;
    }

    /**
     * 检查密码
     *
     * @param pwdVO
     * @return
     */
    @ApiOperation(value = "检查密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id", required = true),
            @ApiImplicitParam(name = "pwd", value = "原用户密码", required = true)
    })
    @PostMapping("/checkPwd")
    public ResponseDTO checkPwd(PwdVO pwdVO) {
        int count = userService.checkPwd(pwdVO.getUid(), MD5.md5(pwdVO.getPwd()));
        return new ResponseDTO(100, "检查密码成功", count, null);
    }

    @ApiOperation(value = "更新密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id", required = true),
            @ApiImplicitParam(name = "pwd", value = "新用户密码", required = true)
    })
    @PostMapping("/updatePwd")
    public ResponseDTO updatePwd(PwdVO pwdVO) {
        int count = userService.updatePwd(pwdVO.getUid(), MD5.md5(pwdVO.getPwd()), 1);
        return new ResponseDTO(100, "更新密码成功", count, null);
    }
}
