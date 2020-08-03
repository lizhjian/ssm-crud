package com.ziroom.crm.cm.mapper.activity;

import com.ziroom.crm.cm.domain.activity.ActivityCompensate;
import com.ziroom.crm.cm.domain.activity.ActivityCompensateKey;

public interface ActivityCompensateMapper {
    int deleteByPrimaryKey(ActivityCompensateKey key);

    int insert(ActivityCompensate record);

    int insertSelective(ActivityCompensate record);

    ActivityCompensate selectByPrimaryKey(ActivityCompensateKey key);

    int updateByPrimaryKeySelective(ActivityCompensate record);

    int updateByPrimaryKey(ActivityCompensate record);
}