package com.jq.dao;

import com.jq.pojo.HrNewemp;

public interface HrNewempMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrNewemp record);

    int insertSelective(HrNewemp record);

    HrNewemp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrNewemp record);

    int updateByPrimaryKeyWithBLOBs(HrNewemp record);

    int updateByPrimaryKey(HrNewemp record);
}