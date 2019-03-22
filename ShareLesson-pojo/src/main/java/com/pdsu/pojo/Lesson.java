package com.pdsu.pojo;

import java.util.Date;

/**
 * 课程基本信息表
 * 
 * @author wcyong
 * 
 * @date 2019-03-22
 */
public class Lesson {
    /**
     * 课程id
     */
    private String lId;

    /**
     * 上课老师id
     */
    private String tId;

    /**
     * 课程价格，分为单位
     */
    private Integer price;

    /**
     * 课程介绍
     */
    private String introduction;

    /**
     * 预计时长
     */
    private Integer lTime;

    /**
     * 课程开始时间
     */
    private Date beginTime;

    /**
     * 报名结束时间
     */
    private Date endTime;

    /**
     * 最少开课人数
     */
    private Integer miniNum;

    /**
     * 最多开课人数
     */
    private Integer maxNum;

    /**
     * 课程介绍图片
     */
    private String pic;

    /**
     * 上课地点
     */
    private String location;

    /**
     * 分类id
     */
    private String classifyId;

    /**
     * 审核状态
     */
    private Integer exam;

    /**
     * 点赞次数
     */
    private Integer praise;

    /**
     * 是否收费
     */
    private Integer ischarge;

    /**
     * 课程名称
     */
    private String lName;

    /**
     * 已经报名人数
     */
    private Integer currentNum;

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId == null ? null : lId.trim();
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId == null ? null : tId.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getlTime() {
        return lTime;
    }

    public void setlTime(Integer lTime) {
        this.lTime = lTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getMiniNum() {
        return miniNum;
    }

    public void setMiniNum(Integer miniNum) {
        this.miniNum = miniNum;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId == null ? null : classifyId.trim();
    }

    public Integer getExam() {
        return exam;
    }

    public void setExam(Integer exam) {
        this.exam = exam;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public Integer getIscharge() {
        return ischarge;
    }

    public void setIscharge(Integer ischarge) {
        this.ischarge = ischarge;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName == null ? null : lName.trim();
    }

    public Integer getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Integer currentNum) {
        this.currentNum = currentNum;
    }
}