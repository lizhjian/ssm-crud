package com.ziroom.azeroth.entity;

import java.util.Date;

public class TargetImport {
    private Long id;

    private Date targetDate;

    private String groupCode;

    private Integer azerothKeeperType;

    private Long baseTargetId;

    private String targetName;

    private String targetValue;

    private Date createDate;

    private Date lastModifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public Integer getAzerothKeeperType() {
        return azerothKeeperType;
    }

    public void setAzerothKeeperType(Integer azerothKeeperType) {
        this.azerothKeeperType = azerothKeeperType;
    }

    public Long getBaseTargetId() {
        return baseTargetId;
    }

    public void setBaseTargetId(Long baseTargetId) {
        this.baseTargetId = baseTargetId;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(String targetValue) {
        this.targetValue = targetValue;
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