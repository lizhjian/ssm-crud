package com.ziroom.crm.cm.mapper.activity;

import com.ziroom.crm.cm.domain.activity.ActivityRecord;
import com.ziroom.crm.cm.domain.activity.ActivityRecordKey;

public interface ActivityRecordMapper {
    int deleteByPrimaryKey(ActivityRecordKey key);

    int insert(ActivityRecord record);

    int insertSelective(ActivityRecord record);

    ActivityRecord selectByPrimaryKey(ActivityRecordKey key);

    int updateByPrimaryKeySelective(ActivityRecord record);

    int updateByPrimaryKey(ActivityRecord record);
}