package com.wuxin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDtl {
    private Integer id;

    private String orderNum;

    private Integer proId;

    private Integer isDel;

    private Date modifyTime;
}