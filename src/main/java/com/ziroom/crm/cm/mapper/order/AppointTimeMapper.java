package com.ziroom.crm.cm.mapper.order;

import com.ziroom.crm.cm.domain.order.AppointTime;

public interface AppointTimeMapper {
    int deleteByPrimaryKey(AppointTime key);

    int insert(AppointTime record);

    int insertSelective(AppointTime record);

    AppointTime selectByPrimaryKey(AppointTime key);

    int updateByPrimaryKeySelective(AppointTime record);

    int updateByPrimaryKey(AppointTime record);
}