package com.jq.dao;

import com.jq.pojo.HrEmployee;

public interface HrEmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrEmployee record);

    int insertSelective(HrEmployee record);

    HrEmployee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrEmployee record);

    int updateByPrimaryKey(HrEmployee record);
}