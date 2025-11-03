package com.jq.dao;

import com.jq.pojo.ApplyAuthority;

public interface ApplyAuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApplyAuthority record);

    int insertSelective(ApplyAuthority record);

    ApplyAuthority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApplyAuthority record);

    int updateByPrimaryKeyWithBLOBs(ApplyAuthority record);

    int updateByPrimaryKey(ApplyAuthority record);
}