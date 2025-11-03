package com.jq.service.impl;

import com.jq.dao.KittenAuthorityMapper;
import com.jq.dao.KittenFieldMapper;
import com.jq.dao.KittenMemoMapper;
import com.jq.dao.KittenUserMapper;
import com.jq.dao.ex.Kitten_userMapperEX;
import com.jq.pojo.*;
import com.jq.service.Kitten_userService;

import com.jq.util.MD5;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class Kitten_userServiceImpl implements Kitten_userService {
    @Resource
    private Kitten_userMapperEX kittenUserMapperEX;

    @Resource
    private KittenUserMapper kittenUserMapper;

    @Resource
    private KittenAuthorityMapper kittenAuthorityMapper;

    @Resource
    private KittenFieldMapper kittenFieldMapper;



    @Override
    public List<KittenUser> getKittenUserList(KittenUser kittenUser) {
        return kittenUserMapperEX.getKittenUserList(kittenUser);
    }

    @Override
    public Map<String, String> getUserinfo(KittenUser kittenUser) {
        return kittenUserMapperEX.getUserinfo(kittenUser);
    }

    @Override
    public List<KittenAuthority> getKittenAuthorityList(KittenAuthority kittenAuthority) {
        return kittenUserMapperEX.getKittenAuthorityList(kittenAuthority);
    }

    @Override
    public int delKittenUser(Long user_id) {
        return kittenUserMapper.deleteByPrimaryKey(user_id);
    }

    @Override
    public int addKittenUser(KittenUser kittenUser) {
//        从hr职工表中获取基本信息
        HrEmployee hrEmployee=kittenUserMapperEX.getHrEmployee(kittenUser.getWorkNum());
        kittenUser.setUser_name(hrEmployee.getName());
        kittenUser.setUser_code(hrEmployee.getWorkNum());
        kittenUser.setUser_password(MD5.md5("111111"));
//        同时往备忘录表新增
        kittenUserMapperEX.addMemo(hrEmployee.getWorkNum());
        return kittenUserMapper.insertSelective(kittenUser);
    }

    @Override
    public void editKittenUser(KittenUser kittenUser) {
        kittenUserMapper.updateByPrimaryKeySelective(kittenUser);
    }

    @Override
    public int addAuthority(KittenAuthority kittenAuthority) {
        kittenAuthority.setAuthority_description("权限下拉框");
        return kittenAuthorityMapper.insertSelective(kittenAuthority);
    }

    @Override
    public int delAuthority(int t_id) {
        return kittenAuthorityMapper.deleteByPrimaryKey(t_id);
    }

    @Override
    public List<Map<Integer, String>> getLeftUserList() {
        return kittenUserMapperEX.getLeftUserList();
    }

    @Override
    public int editAuthorityMember(String member, int tid) {
        return kittenUserMapperEX.editAuthorityMember(member,tid);
    }


    @Override
    public List<Map<String, String>> getFieldValueByTypeID(String typeId) {
        return kittenUserMapperEX.getFieldValueByTypeID(typeId);
    }

    @Override
    public int editAuthority(KittenAuthority authority) {
        return kittenAuthorityMapper.updateByPrimaryKeySelective(authority);
    }

    @Override
    public KittenUser getLoginUser(String workNum) {
        return kittenUserMapperEX.getLoginUser(workNum);
    }

    @Override
    public KittenMemo getKittenMemo(String workNum) {
        return kittenUserMapperEX.getKittenMemo(workNum);
    }

    @Override
    public void editKittenMemo(KittenMemo kittenMemo) {
        kittenUserMapperEX.editKittenMemo(kittenMemo);
    }

    @Override
    public List<Map<String, String>> getApplyUser(String selectType,String applicant_name) {
        return kittenUserMapperEX.getApplyUser(selectType,applicant_name);
    }

    @Override
    public int editApplyUser(Integer id,String status) {
        return kittenUserMapperEX.editApplyUser(id,status);
    }

    @Override
    public int countApplyUser(String applicant_name) {
        return kittenUserMapperEX.countApplyUser(applicant_name);
    }

    @Override
    public String getDepartment(String workNum) {
        return kittenUserMapperEX.getDepartment(workNum);
    }

    @Override
    public List<KittenField> getKittenLield(KittenField kittenField) {
        return kittenUserMapperEX.getKittenLield(kittenField);
    }

    @Override
    public int addKittenField(KittenField kittenField) {
        return kittenFieldMapper.insertSelective(kittenField);
    }

    @Override
    public int editKittenField(KittenField kittenField) {
        return kittenFieldMapper.updateByPrimaryKeySelective(kittenField);
    }

    @Override
    public int delKittenField(Integer f_id) {
        return kittenFieldMapper.deleteByPrimaryKey(f_id);
    }


}
