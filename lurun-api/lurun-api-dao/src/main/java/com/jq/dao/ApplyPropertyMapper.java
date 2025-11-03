package com.jq.dao;

import com.jq.pojo.ApplyProperty;

public interface ApplyPropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApplyProperty record);

    int insertSelective(ApplyProperty record);

    ApplyProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApplyProperty record);

    int updateByPrimaryKey(ApplyProperty record);
}