package com.ziroom.azeroth.entity;

import java.util.Date;

public class OkrTargetUser {
    private Long id;

    private Integer baseTargetId;

    private String azerothKeeperType;

    private Integer targetType;

    private Integer targetBusType;

    private Integer targetWeight;

    private Long parentId;

    private String targetFileType;

    private Integer targetOrder;

    private Date createDate;

    private Date lastModifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBaseTargetId() {
        return baseTargetId;
    }

    public void setBaseTargetId(Integer baseTargetId) {
        this.baseTargetId = baseTargetId;
    }

    public String getAzerothKeeperType() {
        return azerothKeeperType;
    }

    public void setAzerothKeeperType(String azerothKeeperType) {
        this.azerothKeeperType = azerothKeeperType;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public Integer getTargetBusType() {
        return targetBusType;
    }

    public void setTargetBusType(Integer targetBusType) {
        this.targetBusType = targetBusType;
    }

    public Integer getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(Integer targetWeight) {
        this.targetWeight = targetWeight;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getTargetFileType() {
        return targetFileType;
    }

    public void setTargetFileType(String targetFileType) {
        this.targetFileType = targetFileType;
    }

    public Integer getTargetOrder() {
        return targetOrder;
    }

    public void setTargetOrder(Integer targetOrder) {
        this.targetOrder = targetOrder;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }
}