package com.ziroom.azeroth.entity;

import java.util.Date;

public class GoalTargetUser {
    private Long id;

    private Integer baseTargetId;

    private String azerothKeeperType;

    private Long parentId;

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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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