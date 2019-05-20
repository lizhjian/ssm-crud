package com.ziroom.azeroth.entity;

import java.util.Date;

public class TargetInfo {
    private Long id;

    private Date targetDate;

    private String userCode;

    private Date lastConfirmPassDate;

    private String lastConfirmPassUser;

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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Date getLastConfirmPassDate() {
        return lastConfirmPassDate;
    }

    public void setLastConfirmPassDate(Date lastConfirmPassDate) {
        this.lastConfirmPassDate = lastConfirmPassDate;
    }

    public String getLastConfirmPassUser() {
        return lastConfirmPassUser;
    }

    public void setLastConfirmPassUser(String lastConfirmPassUser) {
        this.lastConfirmPassUser = lastConfirmPassUser;
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