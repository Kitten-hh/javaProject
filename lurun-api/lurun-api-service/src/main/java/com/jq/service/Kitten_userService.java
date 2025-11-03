package com.jq.service;


import com.jq.pojo.*;

import java.util.List;
import java.util.Map;

public interface Kitten_userService {

    List<KittenUser> getKittenUserList(KittenUser kittenUser);

    Map<String, String> getUserinfo(KittenUser kittenUser);

    List<KittenAuthority> getKittenAuthorityList(KittenAuthority kittenAuthority);

    int delKittenUser(Long user_id);

    int addKittenUser(KittenUser kittenUser);

    void editKittenUser(KittenUser kittenUser);

    int addAuthority(KittenAuthority kittenAuthority);

    int delAuthority(int t_id);

    List<Map<Integer, String>> getLeftUserList();

    int editAuthorityMember(String member, int tid);


    List<Map<String, String>> getFieldValueByTypeID(String typeId);

    int editAuthority(KittenAuthority authority);

    KittenUser getLoginUser(String workNum);

    KittenMemo getKittenMemo(String workNum);

    void editKittenMemo(KittenMemo kittenMemo);

    List<Map<String, String>> getApplyUser(String selectType,String applicant_name);

    int editApplyUser(Integer id,String status);

    int countApplyUser(String applicant_name);

    String getDepartment(String workNum);

    List<KittenField> getKittenLield(KittenField kittenField);

    int addKittenField(KittenField kittenField);

    int editKittenField(KittenField kittenField);

    int delKittenField(Integer f_id);
}
