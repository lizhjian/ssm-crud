package com.wuxin.mapper;

import com.wuxin.entity.OrderDtl;
import com.wuxin.entity.OrderPri;

import java.util.List;

public interface OrderPriMapper {
    int deleteByPrimaryKey(OrderPri key);

    int insert(OrderPri record);

    int insertSelective(OrderPri record);

    OrderPri selectByPrimaryKey(OrderPri key);

    int updateByPrimaryKeySelective(OrderPri record);

    int updateByPrimaryKey(OrderPri record);

    List<OrderPri> selectByParams(OrderPri pri);

    List<OrderPri> selectByParamsAll(OrderPri pri);
}