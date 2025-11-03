package com.jq.dao;

import com.jq.pojo.KittenProperty;

public interface KittenPropertyMapper {
    int deleteByPrimaryKey(Integer p_id);

    int insert(KittenProperty record);

    int insertSelective(KittenProperty record);

    KittenProperty selectByPrimaryKey(Integer p_id);

    int updateByPrimaryKeySelective(KittenProperty record);

    int updateByPrimaryKey(KittenProperty record);
}