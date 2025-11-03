package com.jq.service;


import com.jq.pojo.*;

import java.util.List;
import java.util.Map;

public interface Kitten_allUserService {

    List<KittenAuthority> myAuthorityList(List<String> nameList);

    int addApplyAuthority(ApplyAuthority applyAuthority);

    List<ApplyAuthority> getauthorityService(String userName,String selectType, Integer userType);

    int editauthorityService(Integer id, String status);

    int countApplyAuthority();

    int addApplyMaintain(ApplyMaintain applyMaintain);

    List<ApplyMaintain> getApplyMaintain(ApplyMaintain applyMaintain);

    int editApplyMaintain(ApplyMaintain applyMaintain,Integer type);

    List<ApplyProperty> getKittenPropertyList(ApplyProperty applyProperty);

    int addApplyProperty(ApplyProperty applyProperty);

    int editApplyProperty(ApplyProperty applyProperty, Integer type);

    List<HrEmployee> getAddressBook(HrEmployee hrEmployee);
}
