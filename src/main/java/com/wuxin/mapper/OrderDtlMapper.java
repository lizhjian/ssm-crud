package com.wuxin.mapper;

import com.wuxin.entity.OrderDtl;

public interface OrderDtlMapper {
    int deleteByPrimaryKey(OrderDtl key);

    int insert(OrderDtl record);

    int insertSelective(OrderDtl record);

    OrderDtl selectByPrimaryKey(OrderDtl key);

    int updateByPrimaryKeySelective(OrderDtl record);

    int updateByPrimaryKey(OrderDtl record);
}