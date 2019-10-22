package com.ziroom.crm.cm.mapper.order;

import com.ziroom.crm.cm.domain.order.oSigninRecord;
import com.ziroom.crm.cm.domain.order.oSigninRecordKey;

public interface oSigninRecordMapper {
    int deleteByPrimaryKey(oSigninRecordKey key);

    int insert(oSigninRecord record);

    int insertSelective(oSigninRecord record);

    oSigninRecord selectByPrimaryKey(oSigninRecordKey key);

    int updateByPrimaryKeySelective(oSigninRecord record);

    int updateByPrimaryKey(oSigninRecord record);
}