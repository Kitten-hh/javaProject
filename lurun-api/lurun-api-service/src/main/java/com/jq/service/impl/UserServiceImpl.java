package com.jq.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;

//import com.jq.dao.TJquserMapper;
import com.jq.dao.ex.UserMapperEX;
import com.jq.pojo.KittenUser;
import com.jq.pojo.TJquser;
import com.jq.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserMapperEX userMapperEX;

//    @Resource
//    private TJquserMapper tJquserMapper;

    @Override
    public KittenUser login(String userCode, String md5pwd) {
        return userMapperEX.getUserByLogin(userCode,md5pwd);
    }

    @Override
    public int checkPwd(Long uid, String md5) {
        return userMapperEX.checkPwd(uid,md5);
    }

    @Override
    public int updatePwd(Long uid, String md5, int firstLogin) {
        return userMapperEX.updatePwd(uid,md5,firstLogin);
    }

//    @Override
//     
//    public int addUser(TJquser tJquser) {
//        return tJquserMapper.insertSelective(tJquser);
//    }

    @Override
    public List<KittenUser> getUserList(String sname, String sdep) {
        return userMapperEX.getUserList(sname,sdep);
    }

    @Override
    public int getUserCount(String sname, String sdep) {
        return userMapperEX.getUserCount(sname,sdep);
    }

    @Override
    public int updateStatus(Long user_id, Integer status) {
        return userMapperEX.updateStatus(user_id,status);
    }

    @Override
    public KittenUser getUser(Long uid) {
        return userMapperEX.getUserById(uid);
    }
}
