package com.pdsu.pojo;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-04-18
 */
public class Apply {
    private String aId;

    private String uId;

    private String content;

    /**
     * 状态（0：未读，1：通过，2：未通过）
     */
    private Integer status;

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId == null ? null : aId.trim();
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}