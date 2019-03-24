package com.pdsu.pojo;

/**
 * 学生课程中间表
 * 
 * @author wcyong
 * 
 * @date 2019-03-24
 */
public class Class_User {
    /**
     * 记录id
     */
    private String rId;

    /**
     * 课程id
     */
    private String lId;

    /**
     * 学生id
     */
    private String sId;

    /**
     * 状态
     */
    private Integer status;

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId == null ? null : lId.trim();
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId == null ? null : sId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}