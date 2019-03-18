package com.pdsu.pojo;

import java.util.Date;

/**
 * 支付记录
 * 
 * @author wcyong
 * 
 * @date 2019-03-18
 */
public class Pay_record {
    /**
     * 支付订单号
     */
    private String outTradeNo;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 支付完成时间
     */
    private Date payTime;

    /**
     * 支付金额（分）
     */
    private Integer totalFee;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 交易码
     */
    private String transactionId;

    /**
     * 交易状态
     */
    private Integer tradeState;

    /**
     * 订单编号列表
     */
    private String orderList;

    /**
     * 支付类型
     */
    private Integer payType;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    public Integer getTradeState() {
        return tradeState;
    }

    public void setTradeState(Integer tradeState) {
        this.tradeState = tradeState;
    }

    public String getOrderList() {
        return orderList;
    }

    public void setOrderList(String orderList) {
        this.orderList = orderList == null ? null : orderList.trim();
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }
}