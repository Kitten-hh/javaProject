package com.jq.dao;

import com.jq.pojo.KittenMemo;

public interface KittenMemoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KittenMemo record);

    int insertSelective(KittenMemo record);

    KittenMemo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KittenMemo record);

    int updateByPrimaryKeyWithBLOBs(KittenMemo record);

    int updateByPrimaryKey(KittenMemo record);
}