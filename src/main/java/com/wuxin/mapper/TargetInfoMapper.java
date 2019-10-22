package com.wuxin.mapper;

import com.wuxin.entity.TargetInfo;
import com.wuxin.entity.TargetInfoKey;

public interface TargetInfoMapper {
    int deleteByPrimaryKey(TargetInfoKey key);

    int insert(TargetInfo record);

    int insertSelective(TargetInfo record);

    TargetInfo selectByPrimaryKey(TargetInfoKey key);

    int updateByPrimaryKeySelective(TargetInfo record);

    int updateByPrimaryKey(TargetInfo record);
}