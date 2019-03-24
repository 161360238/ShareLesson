package com.pdsu.pojo;

import java.util.Date;

/**
 * 定单表
 * 
 * @author wcyong
 * 
 * @date 2019-03-24
 */
public class Orders {
    /**
     * 订单id
     */
    private String orderId;

    /**
     * 实付金额
     */
    private Integer payment;

    /**
     * 状态（0为未付款，1为已经付款，2为已删除）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 付款时间
     */
    private Date payTime;

    /**
     * 交易完成时间
     */
    private Date endTime;

    /**
     * 交易关闭时间
     */
    private Date closeTime;

    /**
     * 用户id
     */
    private String uId;

    /**
     * 买家时间
     */
    private String sMessage;

    /**
     * 买家昵称
     */
    private String sNick;

    /**
     * 买家是否已经评价
     */
    private Integer sRate;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getsMessage() {
        return sMessage;
    }

    public void setsMessage(String sMessage) {
        this.sMessage = sMessage == null ? null : sMessage.trim();
    }

    public String getsNick() {
        return sNick;
    }

    public void setsNick(String sNick) {
        this.sNick = sNick == null ? null : sNick.trim();
    }

    public Integer getsRate() {
        return sRate;
    }

    public void setsRate(Integer sRate) {
        this.sRate = sRate;
    }
}