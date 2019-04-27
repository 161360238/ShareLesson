package com.pdsu.pojo;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-04-18
 */
public class Praise_user {
    /**
     * 记录id
     */
    private String rid;

    /**
     * 课程或老师id
     */
    private String lTId;

    /**
     * 用户id
     */
    private String uId;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
    }

    public String getlTId() {
        return lTId;
    }

    public void setlTId(String lTId) {
        this.lTId = lTId == null ? null : lTId.trim();
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }
}