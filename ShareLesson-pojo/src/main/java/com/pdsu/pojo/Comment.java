package com.pdsu.pojo;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-04-18
 */
public class Comment {
    /**
     * 评论id
     */
    private String commentId;

    /**
     * 作者id
     */
    private String uId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private Date created;

    /**
     * 父id
     */
    private String pid;

    /**
     * 1，为正常，0为已删除
     */
    private Integer status;

    /**
     * 课程id
     */
    private String lId;

    /**
     * 评价星级
     */
    private Integer star;

    /**
     * 用户名字
     */
    private String uName;

    /**
     * 用户图片位置
     */
    private String uImg;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId == null ? null : lId.trim();
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuImg() {
        return uImg;
    }

    public void setuImg(String uImg) {
        this.uImg = uImg == null ? null : uImg.trim();
    }
}