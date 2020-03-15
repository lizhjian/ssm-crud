package com.wuxin.mapper;

import com.wuxin.entity.OrderDtl;
import com.wuxin.entity.OrderPri;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderPriMapper {
    int deleteByPrimaryKey(OrderPri key);

    int insert(OrderPri record);

    int insertSelective(OrderPri record);

    OrderPri selectByPrimaryKey(OrderPri key);

    int updateByPrimaryKeySelective(OrderPri record);

    int updateByPrimaryKey(OrderPri record);

    List<OrderPri> selectByParams(OrderPri pri);

    List<OrderPri> selectByParamsAll(OrderPri pri);

    List<OrderPri> selectById(String orderNum);


    List<OrderPri> selectByField(@Param("id") Integer id, @Param("orderNum") String orderNum);
    List<OrderPri> selectByFieldV2(@Param("id") Integer id, @Param("orderNum") String orderNum);

    List<OrderPri> selectByFieldV3(Integer id, String orderNum);


    int updateField(@Param("id") Integer id, @Param("orderNum") String orderNum, @Param("isDel") Integer isDel);
    int updateFieldV2(@Param("id") Integer id, @Param("orderNum") String orderNum, @Param("isDel") Integer isDel);

    List<OrderPri> selectBatch(int[] arr);

    List<OrderPri> selectBatchList(List<Integer> idList);

    List<OrderPri> selectBatchListV2(@Param("idList") List<Integer> idList, @Param("orders")List<String> orders);

    List<OrderPri> selectByCase(@Param("id") Integer id, @Param("orderNum") String orderNum, @Param("isDel") Integer isDel);

    List<OrderPri> selectListParam(@Param("orderPri") OrderPri orderPri);

    List<OrderPri> selectListByMap(@Param("orderPriMap") Map map);


    List<OrderPri> selectListByMulEntity(@Param("pri") OrderPri pri, @Param("dtl") OrderDtl dtl);

}