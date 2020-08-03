package com.ziroom.crm.cm.domain.activity;

import java.util.Date;

public class ActivityCompensate extends ActivityCompensateKey {
    private Long activityId;

    private String activityNode;

    private String status;

    private Integer executeNum;

    private Integer isDel;

    private Date createTime;

    private String createCode;

    private Date lastModifyTime;

    private String lastModifyCode;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityNode() {
        return activityNode;
    }

    public void setActivityNode(String activityNode) {
        this.activityNode = activityNode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getExecuteNum() {
        return executeNum;
    }

    public void setExecuteNum(Integer executeNum) {
        this.executeNum = executeNum;
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