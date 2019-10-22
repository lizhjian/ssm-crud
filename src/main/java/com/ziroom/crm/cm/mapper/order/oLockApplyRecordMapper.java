package com.ziroom.crm.cm.mapper.order;

import com.ziroom.crm.cm.domain.order.oLockApplyRecord;
import com.ziroom.crm.cm.domain.order.oLockApplyRecordKey;

public interface oLockApplyRecordMapper {
    int deleteByPrimaryKey(oLockApplyRecordKey key);

    int insert(oLockApplyRecord record);

    int insertSelective(oLockApplyRecord record);

    oLockApplyRecord selectByPrimaryKey(oLockApplyRecordKey key);

    int updateByPrimaryKeySelective(oLockApplyRecord record);

    int updateByPrimaryKey(oLockApplyRecord record);
}