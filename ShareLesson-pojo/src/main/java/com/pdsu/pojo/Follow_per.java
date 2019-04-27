package com.pdsu.pojo;

/**
 * 关注关系表
 * 
 * @author wcyong
 * 
 * @date 2019-04-18
 */
public class Follow_per {
    /**
     * 关注记录id
     */
    private String followId;

    /**
     * 学生id
     */
    private String sId;

    /**
     * 老师id
     */
    private String tId;

    public String getFollowId() {
        return followId;
    }

    public void setFollowId(String followId) {
        this.followId = followId == null ? null : followId.trim();
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId == null ? null : sId.trim();
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId == null ? null : tId.trim();
    }
}