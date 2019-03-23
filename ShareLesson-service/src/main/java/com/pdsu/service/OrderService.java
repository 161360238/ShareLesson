package com.pdsu.service;

import com.pdsu.mypojo.MyOrderParam;
import com.pdsu.pojo.Orders;
import com.pdsu.pojo.Order_item;
import com.pdsu.pojo.Orders;
import com.pdsu.pojo.User;

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
}
