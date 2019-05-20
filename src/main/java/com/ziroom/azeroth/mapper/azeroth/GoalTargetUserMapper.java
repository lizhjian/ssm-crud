package com.ziroom.azeroth.mapper.azeroth;

import com.ziroom.azeroth.entity.GoalTargetUser;
import java.util.List;

public interface GoalTargetUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoalTargetUser record);

    GoalTargetUser selectByPrimaryKey(Long id);

    List<GoalTargetUser> selectAll();

    int updateByPrimaryKey(GoalTargetUser record);
}