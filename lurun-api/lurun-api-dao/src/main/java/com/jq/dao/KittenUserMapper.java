package com.jq.dao;

import com.jq.pojo.KittenUser;

public interface KittenUserMapper {
    int deleteByPrimaryKey(Long user_id);

    int insert(KittenUser record);

    int insertSelective(KittenUser record);

    KittenUser selectByPrimaryKey(Long user_id);

    int updateByPrimaryKeySelective(KittenUser record);

    int updateByPrimaryKey(KittenUser record);
}