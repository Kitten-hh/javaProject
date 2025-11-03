package com.jq.dao.ex;


import com.jq.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface Kitten_userMapperEX {

    List<KittenUser> getKittenUserList(KittenUser kittenUser);

    Map<String, String> getUserinfo(KittenUser kittenUser);

    List<KittenAuthority> getKittenAuthorityList(KittenAuthority kittenAuthority);

    List<Map<Integer, String>> getLeftUserList();

    int editAuthorityMember(String member, int tid);


    List<Map<String, String>> getFieldValueByTypeID(String typeId);

    HrEmployee getHrEmployee(String workNum);

    KittenUser getLoginUser(String workNum);

    KittenMemo getKittenMemo(String workNum);

    void editKittenMemo(KittenMemo kittenMemo);

    List<Map<String, String>> getApplyUser(@Param("selectType")String selectType,@Param("applicant_name")String applicant_name);

    int editApplyUser(@Param("id")Integer id,@Param("status")String status);

    int countApplyUser(@Param("applicant_name")String applicant_name);

    String getDepartment(String workNum);

    List<KittenField> getKittenLield(KittenField kittenField);

    void addMemo(String workNum);
}
