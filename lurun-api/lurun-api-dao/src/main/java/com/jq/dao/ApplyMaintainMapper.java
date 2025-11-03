package com.jq.dao;

import com.jq.pojo.ApplyMaintain;

public interface ApplyMaintainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApplyMaintain record);

    int insertSelective(ApplyMaintain record);

    ApplyMaintain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApplyMaintain record);

    int updateByPrimaryKey(ApplyMaintain record);
}