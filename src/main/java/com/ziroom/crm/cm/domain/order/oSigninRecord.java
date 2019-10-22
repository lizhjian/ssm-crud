package com.ziroom.crm.cm.domain.order;

import java.util.Date;

public class oSigninRecord extends oSigninRecordKey {
    private Long businessKey;

    private String signinScene;

    private Long invNo;

    private String signinUserCode;

    private String hasSmartLock;

    private String isOnline;

    private String isSigninSuccess;

    private String signinType;

    private Date signinTime;

    private String signinLon;

    private String signinLat;

    private String destLon;

    private String destLat;

    private Date applyPwdTime;

    private Date openLockTime;

    private Integer isDel;

    private Date createTime;

    private String creatorCode;

    private Date lastModifyTime;

    private String modifierCode;

    public Long getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(Long businessKey) {
        this.businessKey = businessKey;
    }

    public String getSigninScene() {
        return signinScene;
    }

    public void setSigninScene(String signinScene) {
        this.signinScene = signinScene;
    }

    public Long getInvNo() {
        return invNo;
    }

    public void setInvNo(Long invNo) {
        this.invNo = invNo;
    }

    public String getSigninUserCode() {
        return signinUserCode;
    }

    public void setSigninUserCode(String signinUserCode) {
        this.signinUserCode = signinUserCode;
    }

    public String getHasSmartLock() {
        return hasSmartLock;
    }

    public void setHasSmartLock(String hasSmartLock) {
        this.hasSmartLock = hasSmartLock;
    }

    public String getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline;
    }

    public String getIsSigninSuccess() {
        return isSigninSuccess;
    }

    public void setIsSigninSuccess(String isSigninSuccess) {
        this.isSigninSuccess = isSigninSuccess;
    }

    public String getSigninType() {
        return signinType;
    }

    public void setSigninType(String signinType) {
        this.signinType = signinType;
    }

    public Date getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(Date signinTime) {
        this.signinTime = signinTime;
    }

    public String getSigninLon() {
        return signinLon;
    }

    public void setSigninLon(String signinLon) {
        this.signinLon = signinLon;
    }

    public String getSigninLat() {
        return signinLat;
    }

    public void setSigninLat(String signinLat) {
        this.signinLat = signinLat;
    }

    public String getDestLon() {
        return destLon;
    }

    public void setDestLon(String destLon) {
        this.destLon = destLon;
    }

    public String getDestLat() {
        return destLat;
    }

    public void setDestLat(String destLat) {
        this.destLat = destLat;
    }

    public Date getApplyPwdTime() {
        return applyPwdTime;
    }

    public void setApplyPwdTime(Date applyPwdTime) {
        this.applyPwdTime = applyPwdTime;
    }

    public Date getOpenLockTime() {
        return openLockTime;
    }

    public void setOpenLockTime(Date openLockTime) {
        this.openLockTime = openLockTime;
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

    public String getCreatorCode() {
        return creatorCode;
    }

    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getModifierCode() {
        return modifierCode;
    }

    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode;
    }
}