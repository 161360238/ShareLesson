package com.pdsu.service;

import com.pdsu.mypojo.MyOrderParam;
import com.pdsu.pojo.*;
import com.pdsu.pojo.Orders;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/22
 * @Description: com.pdsu.service
 * @version: 1.0
 */
public interface OrderService {

    /**
     *  创建订单
     * @param param
     * @param user
     * @return
     */
    int createOrder(MyOrderParam param, User user);

    /**
     * 向订单表，订单-商品表 写入数
     * 需要处理事务
     * @param order
     * @param order_items
     * @return
     */
    int writeToDatabase(Orders order, List<Order_item> order_items) throws Exception;

    /**
     * 下单之前判断用户是否已经购买过该课程
     * @param lid
     * @param uid
     * @return
     */
    boolean isBought(String lid,String uid);

    /**
     * 删除订单
     * @param getuId
     * @param oid
     * @return
     */
    int deleteOrder(String getuId, String oid) throws Exception;

    /**
     * 用户查看订单（已付款、未付款）
     * @param getuId
     * @param isPay
     * @return
     */
    List<Orders> selectOrder(String getuId, int isPay);

    /**
     * 根据条件查询已经购买的课程
     * @param uid
     * @param condition
     * @return
     */
    List<Lesson> selectBoughtLesson(String uid, int condition);
}
