package com.ziroom.crm.cm.mapper.order;

import com.ziroom.crm.cm.domain.order.oLabel;
import com.ziroom.crm.cm.domain.order.oLabelKey;

public interface oLabelMapper {
    int deleteByPrimaryKey(oLabelKey key);

    int insert(oLabel record);

    int insertSelective(oLabel record);

    oLabel selectByPrimaryKey(oLabelKey key);

    int updateByPrimaryKeySelective(oLabel record);

    int updateByPrimaryKey(oLabel record);
}