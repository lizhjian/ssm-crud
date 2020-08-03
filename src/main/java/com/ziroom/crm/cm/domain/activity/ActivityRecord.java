package com.ziroom.crm.cm.domain.activity;

import java.util.Date;

public class ActivityRecord extends ActivityRecordKey {
    private String keeperCode;

    private String keeperName;

    private String orgName;

    private String uid;

    private String userPhone;

    private Date registerTime;

    private String actionType;

    private Date signTime;

    private String houseType;

    private String keeperType;

    private Integer isDel;

    private Date createTime;

    private String createCode;

    private Date lastModifyTime;

    private String lastModifyCode;

    public String getKeeperCode() {
        return keeperCode;
    }

    public void setKeeperCode(String keeperCode) {
        this.keeperCode = keeperCode;
    }

    public String getKeeperName() {
        return keeperName;
    }

    public void setKeeperName(String keeperName) {
        this.keeperName = keeperName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getKeeperType() {
        return keeperType;
    }

    public void setKeeperType(String keeperType) {
        this.keeperType = keeperType;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateCode() {
        return createCode;
    }

    public void setCreateCode(String createCode) {
        this.createCode = createCode;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getLastModifyCode() {
        return lastModifyCode;
    }

    public void setLastModifyCode(String lastModifyCode) {
        this.lastModifyCode = lastModifyCode;
    }
}