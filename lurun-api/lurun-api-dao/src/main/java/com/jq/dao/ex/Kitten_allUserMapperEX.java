package com.jq.dao.ex;


import com.jq.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface Kitten_allUserMapperEX {


    List<KittenAuthority> myAuthorityList(List<String> nameList);

    List<ApplyAuthority> getauthorityService(@Param("userName")String userName, @Param("selectType")String selectType, @Param("userType")Integer userType);

    int countApplyAuthority();

    List<ApplyMaintain> getApplyMaintain(ApplyMaintain applyMaintain);

    List<ApplyProperty> getKittenPropertyList(ApplyProperty applyProperty);

    List<HrEmployee> getAddressBook(HrEmployee hrEmployee);
}
