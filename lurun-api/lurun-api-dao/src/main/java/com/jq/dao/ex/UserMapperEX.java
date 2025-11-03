package com.jq.dao.ex;

import com.jq.pojo.KittenUser;
import com.jq.pojo.TJquser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapperEX {

    KittenUser getUserByLogin(String userCode, String userPassword);

    int checkPwd(Long uid, String pwd);

    int updatePwd(Long uid, String pwd,int firstLogin);

    int updateStatus(Long uid, Integer status);

    List<KittenUser> getUserList(@Param("sname") String sname, @Param("sdep") String sdep);

    int getUserCount(@Param("sname") String sname,@Param("sdep") String sdep);

    void updateFirstLogin(Long uid);

    KittenUser getUserById(Long uid);
}
