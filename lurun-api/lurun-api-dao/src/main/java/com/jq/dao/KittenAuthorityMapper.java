package com.jq.dao;

import com.jq.pojo.KittenAuthority;

public interface KittenAuthorityMapper {
    int deleteByPrimaryKey(Integer t_id);

    int insert(KittenAuthority record);

    int insertSelective(KittenAuthority record);

    KittenAuthority selectByPrimaryKey(Integer t_id);

    int updateByPrimaryKeySelective(KittenAuthority record);

    int updateByPrimaryKey(KittenAuthority record);
}