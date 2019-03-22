package com.pdsu.mypojo;

import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.Order_item;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/22
 * @Description: com.pdsu.mypojo
 * @version: 1.0
 */
public class MyOrderParam {

    private String payment;  //付款金额

    private List<Order_item> order_item;  //订单条目（商品）

    public String getPayment() {
        return payment;
    }

    public List<Order_item> getOrder_item() {
        return order_item;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void setOrder_item(List<Order_item> order_item) {
        this.order_item = order_item;
    }
}
