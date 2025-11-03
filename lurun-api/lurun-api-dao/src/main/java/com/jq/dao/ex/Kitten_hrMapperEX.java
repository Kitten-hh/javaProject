package com.jq.dao.ex;


import com.jq.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface Kitten_hrMapperEX {

    List<HrEmployee> getEmployeeInfo(HrEmployee hrEmployee);

    void editHomePage(HrHomepage hrHomepage);


    List<HrHomepage> getHomePage();

    List<HrNewemp> getHrNewemp(HrNewemp hrNewemp);
}
