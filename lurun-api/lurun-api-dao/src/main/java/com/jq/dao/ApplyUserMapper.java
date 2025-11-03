package com.jq.dao;

import com.jq.pojo.ApplyUser;

public interface ApplyUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApplyUser record);

    int insertSelective(ApplyUser record);

    ApplyUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApplyUser record);

    int updateByPrimaryKey(ApplyUser record);
}