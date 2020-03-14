package com.wuxin.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderPri {

    private Integer id;

    private String orderNum;

    private Integer isDel;

    List<OrderDtl> dtlList;
}