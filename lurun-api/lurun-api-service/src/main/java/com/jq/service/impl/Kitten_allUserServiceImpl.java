package com.jq.service.impl;

import com.jq.dao.*;
import com.jq.dao.ex.Kitten_allUserMapperEX;
import com.jq.dao.ex.Kitten_userMapperEX;
import com.jq.pojo.*;
import com.jq.service.Kitten_allUserService;
import com.jq.service.Kitten_userService;
import com.jq.util.MD5;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class Kitten_allUserServiceImpl implements Kitten_allUserService {
    @Resource
    private KittenAuthorityMapper kittenAuthorityMapper;

    @Resource
    private Kitten_allUserMapperEX kittenAllUserMapperEX;

    @Resource
    private ApplyAuthorityMapper applyAuthorityMapper;

    @Resource
    private ApplyMaintainMapper applyMaintainMapper;

    @Resource
    private ApplyPropertyMapper applyPropertyMapper;

    @Override
    public List<KittenAuthority> myAuthorityList(List<String> nameList) {
        return kittenAllUserMapperEX.myAuthorityList(nameList);
    }

    @Override
    public int addApplyAuthority(ApplyAuthority applyAuthority) {
        return applyAuthorityMapper.insertSelective(applyAuthority);
    }

    @Override
    public List<ApplyAuthority> getauthorityService(String userName, String selectType, Integer userType) {
        return kittenAllUserMapperEX.getauthorityService(userName, selectType, userType);

    }

    @Override
    public int editauthorityService(Integer id, String status) {
        ApplyAuthority applyAuthority = new ApplyAuthority();
        applyAuthority.setId(id);
        applyAuthority.setStatus(status);
        return applyAuthorityMapper.updateByPrimaryKeySelective(applyAuthority);
    }

    @Override
    public int countApplyAuthority() {
        return kittenAllUserMapperEX.countApplyAuthority();
    }

    @Override
    public int addApplyMaintain(ApplyMaintain applyMaintain) {
        return applyMaintainMapper.insertSelective(applyMaintain);
    }

    @Override
    public List<ApplyMaintain> getApplyMaintain(ApplyMaintain applyMaintain) {
        return kittenAllUserMapperEX.getApplyMaintain(applyMaintain);
    }

    @Override
    public int editApplyMaintain(ApplyMaintain applyMaintain, Integer type) {
        if (type == 1) {
            if (applyMaintain.getStatus().contains("已审核处理")){
                return -1;
            }else{
                if (applyMaintain.getLeader() == null || (applyMaintain.getLeader().equals(""))) {
                    applyMaintain.setStatus("待分配处理人");
                } else {
                    applyMaintain.setStatus("待" + applyMaintain.getLeader() + "处理");
                }
            }
        }
        return applyMaintainMapper.updateByPrimaryKeySelective(applyMaintain);
    }

    @Override
    public List<ApplyProperty> getKittenPropertyList(ApplyProperty applyProperty) {
        return kittenAllUserMapperEX.getKittenPropertyList(applyProperty);
    }

    @Override
    public int addApplyProperty(ApplyProperty applyProperty) {
        return applyPropertyMapper.insertSelective(applyProperty);
    }

    @Override
    public int editApplyProperty(ApplyProperty applyProperty, Integer type) {
        if (type == 1) {
            if (applyProperty.getStatus().contains("已审核处理")){
                return -1;
            }else{
                if (applyProperty.getLeader() == null || (applyProperty.getLeader().equals(""))) {
                    applyProperty.setStatus("待分配处理人");
                } else {
                    applyProperty.setStatus("待" + applyProperty.getLeader() + "处理");
                }
            }
        }
        return applyPropertyMapper.updateByPrimaryKeySelective(applyProperty);
    }

    @Override
    public List<HrEmployee> getAddressBook(HrEmployee hrEmployee) {
        return kittenAllUserMapperEX.getAddressBook(hrEmployee);
    }
}

