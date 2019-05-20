package com.ziroom.azeroth.mapper.azeroth;

import com.ziroom.azeroth.entity.TargetInfo;
import java.util.List;

public interface TargetInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TargetInfo record);

    TargetInfo selectByPrimaryKey(Long id);

    List<TargetInfo> selectAll();

    int updateByPrimaryKey(TargetInfo record);
}