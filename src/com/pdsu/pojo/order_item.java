package com.pdsu.pojo;

/**
 * 定单商品中间表
 * 
 * @author wcyong
 * 
 * @date 2019-03-15
 */
public class order_item {
    /**
     * 记录id
     */
    private String rId;

    /**
     * 定单id
     */
    private String orderId;

    /**
     * 课程id
     */
    private String lId;

    /**
     * 课程名称
     */
    private String lName;

    /**
     * 课程价格
     */
    private Integer lValue;

    /**
     * 图片路径
     */
    private String picPath;

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId == null ? null : lId.trim();
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName == null ? null : lName.trim();
    }

    public Integer getlValue() {
        return lValue;
    }

    public void setlValue(Integer lValue) {
        this.lValue = lValue;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }
}