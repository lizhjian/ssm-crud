package com.ziroom.azeroth.mapper.azeroth;

import com.ziroom.azeroth.entity.OkrTargetUser;
import java.util.List;

public interface OkrTargetUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OkrTargetUser record);

    OkrTargetUser selectByPrimaryKey(Long id);

    List<OkrTargetUser> selectAll();

    int updateByPrimaryKey(OkrTargetUser record);
}