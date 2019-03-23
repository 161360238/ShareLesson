package com.pdsu.service.impl;

import com.pdsu.mapper.OrdersMapper;
import com.pdsu.mapper.Order_itemMapper;
import com.pdsu.mapper.OrdersMapper;
import com.pdsu.mypojo.MyOrderParam;
import com.pdsu.pojo.*;
import com.pdsu.service.OrderService;
import com.pdsu.service.RedisService;
import com.pdsu.utils.CodecUtil;
import com.pdsu.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/22
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RedisService redisServiceImpl;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private Order_itemMapper order_itemMapper;

    @Override
    public int createOrder(MyOrderParam param, User user) {
        //订单表数据
        Orders order = new Orders();
        String oid = CodecUtil.createUUID();
        order.setOrderId(oid); //设置订单id
        order.setPayment(Integer.parseInt(param.getPayment()));    //设置订单金额
        Date date = new Date();
       // order.setCreateTime(date);   //设置订单下单时间
       // order.setUpdateTime(date);   //更新时间
        order.setuId(user.getuId()); //客户id
        order.setsNick(user.getNicname());  //客户昵称
        order.setStatus(1);   //1为已经付款
        order.setsRate(0);  //是否评价（0 为未评价）

        //订单商品表中间表
        for (Order_item item : param.getOrder_item()) {
            item.setrId(CodecUtil.createUUID());
            item.setOrderId(oid);
        }
        //写入数据库
        try {
            int index = this.writeToDatabase(order, param.getOrder_item());
            if (index > 0) {  //写入成功
                //从购物车中删除已经下单商品
                String json = redisServiceImpl.get("cart:" + user.getuId());
                List<Lesson> lessons = JsonUtils.jsonToList(json, Lesson.class);
                List<Lesson> lessonsNew = new ArrayList<>();  //存放要删除（已经下单）的商品
                for (Order_item orderItem : param.getOrder_item()) {    //下单的商品
                    for (Lesson lesson : lessons) {
                        if (lesson.getlId().equals(orderItem.getlId())) {
                            lessonsNew.add(lesson);
                        }
                    }
                }
                for (Lesson lesson : lessonsNew) {
                    lessons.remove(lesson);
                }
                redisServiceImpl.set("cart:" + user.getuId(), JsonUtils.objectToJson(lessons));
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 写入数据库
     *
     * @param orders
     * @param order_items
     * @return
     * @throws Exception
     */
    @Override
    public int writeToDatabase(Orders orders, List<Order_item> order_items) throws Exception {

        int index = ordersMapper.insertSelective(orders);
        for (Order_item orderItem : order_items) {
            index += order_itemMapper.insertSelective(orderItem);
        }
        if (index == 1 + order_items.size()) {
            return 1;
        } else {
            throw new Exception("创建订单失败");
        }
    }
}
