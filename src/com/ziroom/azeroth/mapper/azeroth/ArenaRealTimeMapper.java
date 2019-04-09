package com.ziroom.azeroth.mapper.azeroth;

import com.ziroom.azeroth.entity.AchievementUser.ArenaRealTime;
import com.ziroom.azeroth.entity.AchievementUser.ArenaRealTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArenaRealTimeMapper {
    int countByExample(ArenaRealTimeExample example);

    int deleteByExample(ArenaRealTimeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArenaRealTime record);

    int insertSelective(ArenaRealTime record);

    List<ArenaRealTime> selectByExample(ArenaRealTimeExample example);

    ArenaRealTime selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArenaRealTime record, @Param("example") ArenaRealTimeExample example);

    int updateByExample(@Param("record") ArenaRealTime record, @Param("example") ArenaRealTimeExample example);

    int updateByPrimaryKeySelective(ArenaRealTime record);

    int updateByPrimaryKey(ArenaRealTime record);
}