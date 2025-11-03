package com.jq.dao;

import com.jq.pojo.KittenField;

public interface KittenFieldMapper {
    int deleteByPrimaryKey(Integer f_id);

    int insert(KittenField record);

    int insertSelective(KittenField record);

    KittenField selectByPrimaryKey(Integer f_id);

    int updateByPrimaryKeySelective(KittenField record);

    int updateByPrimaryKey(KittenField record);
}