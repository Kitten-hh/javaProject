package com.jq.service.impl;

import com.jq.dao.*;
import com.jq.dao.ex.Kitten_hrMapperEX;
import com.jq.pojo.ApplyUser;
import com.jq.pojo.HrEmployee;
import com.jq.pojo.HrHomepage;
import com.jq.pojo.HrNewemp;
import com.jq.service.Kitten_hrService;
import com.jq.service.Kitten_userService;
import com.jq.util.MD5;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class Kitten_hrServiceImpl implements Kitten_hrService {

    @Resource
    private Kitten_hrMapperEX kittenHrMapperEX;

    @Resource
    private HrEmployeeMapper hrEmployeeMapper;

    @Resource
    private ApplyUserMapper applyUserMapper;

    @Resource
    private HrNewempMapper hrNewempMapper;


    @Override
    public List<HrEmployee> getEmployeeInfo(HrEmployee hrEmployee) {
        return kittenHrMapperEX.getEmployeeInfo(hrEmployee);
    }

    @Override
    public int addEmployeeInfo(HrEmployee hrEmployee) {
        return hrEmployeeMapper.insertSelective(hrEmployee);
    }

    @Override
    public int editEmployeeInfo(HrEmployee hrEmployee) {
        return hrEmployeeMapper.updateByPrimaryKeySelective(hrEmployee);
    }

    @Override
    public int addApplyUser(ApplyUser applyUser) {
        return applyUserMapper.insertSelective(applyUser);
    }

    @Override
    public void editHomePage(HrHomepage hrHomepage) {
        kittenHrMapperEX.editHomePage(hrHomepage);
    }

    @Override
    public List<HrHomepage> getHomePage() {
        return kittenHrMapperEX.getHomePage();
    }

    @Override
    public List<HrNewemp> getHrNewemp(HrNewemp hrNewemp) {
        return kittenHrMapperEX.getHrNewemp(hrNewemp);
    }

    @Override
    public void editHrNewemp(HrNewemp hrNewemp) {
        hrNewempMapper.updateByPrimaryKeySelective(hrNewemp);
    }

    @Override
    public int addHrNewemp(HrNewemp hrNewemp) {
        return hrNewempMapper.insertSelective(hrNewemp);
    }


}
