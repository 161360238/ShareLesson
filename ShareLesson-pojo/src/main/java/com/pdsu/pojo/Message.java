package com.pdsu.pojo;

import java.util.Date;

/**
 * 消息表
 * 
 * @author wcyong
 * 
 * @date 2019-03-22
 */
public class Message {
    /**
     * 信息id
     */
    private String mId;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 发布者id
     */
    private String fromId;

    /**
     * 接收者id
     */
    private String ownId;

    /**
     * 课程id
     */
    private String lId;

    private Integer status;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId == null ? null : mId.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId == null ? null : fromId.trim();
    }

    public String getOwnId() {
        return ownId;
    }

    public void setOwnId(String ownId) {
        this.ownId = ownId == null ? null : ownId.trim();
    }

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId == null ? null : lId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}