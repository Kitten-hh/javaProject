package com.jq.service;


import com.jq.pojo.KittenUser;
import com.jq.pojo.TJquser;

import java.util.List;

public interface UserService {


    KittenUser login(String userCode, String md5pwd);

    int checkPwd(Long uid, String md5);

    int updatePwd(Long uid, String md5, int firstLogin);

//    int addUser(TJquser tJquser);

    List<KittenUser> getUserList (String sname, String sdep);

    int getUserCount(String sname, String sdep);

    int updateStatus(Long user_id, Integer status);

    KittenUser getUser(Long uid);
}
