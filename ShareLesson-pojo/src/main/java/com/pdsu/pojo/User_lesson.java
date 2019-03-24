package com.pdsu.pojo;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-03-24
 */
public class User_lesson {
    /**
     * 记录id
     */
    private String rId;

    /**
     * 用户id
     */
    private String uId;

    /**
     * 课程id'
     */
    private String lId;

    /**
     * 状态（0已经结束、1未开始）
     */
    private Integer statue;

    /**
     * 备用字段
     */
    private Integer remind;

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId == null ? null : lId.trim();
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

    public Integer getRemind() {
        return remind;
    }

    public void setRemind(Integer remind) {
        this.remind = remind;
    }
}