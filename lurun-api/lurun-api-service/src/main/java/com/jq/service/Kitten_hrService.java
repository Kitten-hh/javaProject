package com.jq.service;


import com.jq.pojo.ApplyUser;
import com.jq.pojo.HrEmployee;
import com.jq.pojo.HrHomepage;
import com.jq.pojo.HrNewemp;

import java.util.List;
import java.util.Map;

public interface Kitten_hrService {

    List<HrEmployee> getEmployeeInfo(HrEmployee hrEmployee);

    int addEmployeeInfo(HrEmployee hrEmployee);

    int editEmployeeInfo(HrEmployee hrEmployee);

    int addApplyUser(ApplyUser applyUser);

    void editHomePage(HrHomepage hrHomepage);


    List<HrHomepage> getHomePage();

    List<HrNewemp> getHrNewemp(HrNewemp hrNewemp);

    void editHrNewemp(HrNewemp hrNewemp);

    int addHrNewemp(HrNewemp hrNewemp);
}
