package com.pdsu.service.impl;

import com.pdsu.mapper.OrdersMapper;
import com.pdsu.mapper.Order_itemMapper;
import com.pdsu.mapper.OrdersMapper;
import com.pdsu.mapper.User_lessonMapper;
import com.pdsu.mypojo.MyOrderParam;
import com.pdsu.pojo.*;
import com.pdsu.service.LessonService;
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

    @Autowired
    private User_lessonMapper user_lessonMapper;

    @Autowired
    private LessonService lessonServiceImpl;


    @Override
    public int createOrder(MyOrderParam param, User user) {
        boolean flag = false;
        for (int i = 0; i < param.getOrder_item().size(); i++) {
            if (this.isBought(param.getOrder_item().get(i).getlId(), user.getuId())) {
                flag = true;
            }
        }
        if (flag == true) {
            //有的商品已经付过款
            return 2;
        }

        //订单表数据
        Orders order = new Orders();
        String oid = CodecUtil.createUUID();
        order.setOrderId(oid); //设置订单id
        order.setPayment(Integer.parseInt(param.getPayment()));    //设置订单金额
        Date date = new Date();
        order.setCreateTime(date);   //设置订单下单时间
        order.setUpdateTime(date);   //更新时间
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
                List<Lesson> lessons = new ArrayList<>();
                if (json != null) {
                    lessons = JsonUtils.jsonToList(json, Lesson.class);
                }
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
                //在user_lesson表中添加数据，改变lesson中已经报名的人数
                for (Order_item orderItem : param.getOrder_item()) {    //下单的商品
                    User_lesson userLesson = new User_lesson();
                    userLesson.setrId(CodecUtil.createUUID());
                    userLesson.setlId(orderItem.getlId());
                    userLesson.setuId(user.getuId());
                    userLesson.setStatue(1);
                    user_lessonMapper.insertSelective(userLesson);
                    Lesson lesson=lessonServiceImpl.selectByLid(userLesson.getlId());
                    lesson.setCurrentNum(lesson.getCurrentNum()+1);  //报名人数加一
                }
                //改变lesson中已经报名的人数

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

    @Override
    public boolean isBought(String lid, String uid) {
        User_lessonExample user_lessonExample = new User_lessonExample();
        user_lessonExample.createCriteria().andLIdEqualTo(lid)
                .andUIdEqualTo(uid);
        List<User_lesson> user_lessons = user_lessonMapper.selectByExample(user_lessonExample);
        if (user_lessons != null && user_lessons.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int deleteOrder(String getuId, String oid) throws Exception {
        //1，在订单表中，设置这个订单状态为删除
        Orders orders = ordersMapper.selectByPrimaryKey(oid);
        orders.setStatus(2);   //设置为删除状态
        int index = ordersMapper.updateByPrimaryKey(orders);  //写回数据库

        //2，查出订单中包含的商品
        Order_itemExample order_itemExample = new Order_itemExample();
        order_itemExample.createCriteria().andOrderIdEqualTo(oid);
        List<Order_item> order_items = order_itemMapper.selectByExample(order_itemExample);

        //3，在user_lesson中删除对应商品记录（真删除）
        for (int i = 0; i < order_items.size(); i++) {
            User_lessonExample user_lessonExample = new User_lessonExample();
            user_lessonExample.createCriteria().andLIdEqualTo(order_items.get(i).getlId());
            index += user_lessonMapper.deleteByExample(user_lessonExample);
        }
        if (index == 1 + order_items.size()) {
            return 1;
        } else {
            throw new Exception("删除订单失败");
        }
    }

    @Override
    public List<Orders> selectOrder(String getuId, int condition) {
        List<Orders> ordersList = new ArrayList<>();
        if (condition == 1) {
            //查看已经付款商品
            OrdersExample ordersExample = new OrdersExample();
            ordersExample.createCriteria().andStatusEqualTo(1);
            ordersList = ordersMapper.selectByExample(ordersExample);
        } else if (condition == 0) {
            //查看未付款商品
            OrdersExample ordersExample = new OrdersExample();
            ordersExample.createCriteria().andStatusEqualTo(0);
            ordersList = ordersMapper.selectByExample(ordersExample);
        } else if (condition == 2) {
            //查看已经付款但未评价订单，
            OrdersExample ordersExample = new OrdersExample();
            ordersExample.createCriteria().andStatusEqualTo(1)
                    .andSRateEqualTo(0);  //未评价
            ordersList = ordersMapper.selectByExample(ordersExample);
        } else if (condition == 3) {
            //查看已经付款且已经评价订单，
            OrdersExample ordersExample = new OrdersExample();
            ordersExample.createCriteria().andStatusEqualTo(1)
                    .andSRateEqualTo(1);  //已经评价
            ordersList = ordersMapper.selectByExample(ordersExample);
        }else if(condition == 4){  //查看已经超时未付款商品

            OrdersExample ordersExample = new OrdersExample();
            ordersExample.createCriteria().andStatusEqualTo(3);
            ordersList = ordersMapper.selectByExample(ordersExample);
        }else if(condition == 5){  //查看全部商品
            OrdersExample ordersExample = new OrdersExample();
            ordersList = ordersMapper.selectByExample(ordersExample);
        }

        return ordersList;
    }

    @Override
    public List<Lesson> selectBoughtLesson(String uid, int condition) {
        List<Lesson> lessons = new ArrayList<>();
        User_lessonExample user_lessonExample = new User_lessonExample();
        user_lessonExample.createCriteria().andUIdEqualTo(uid)
                .andStatueEqualTo(condition);   //根据条件查询开始或者结束
        List<User_lesson> user_lessons = user_lessonMapper.selectByExample(user_lessonExample);

        if (user_lessons != null && user_lessons.size() > 0) {
            for (User_lesson userLesson : user_lessons) {
                lessons.add(lessonServiceImpl.selectByLid(userLesson.getlId()));
            }
        }
        if (lessons != null && lessons.size() > 0) {
            return lessons;
        }
        return null;
    }

    /**
     * 根据订单id查询商品（课程）
     * @param oid
     * @return
     */
    @Override
    public List<Lesson> selectLessonByOid(String oid) {
        List<Lesson> lessons=new ArrayList<>();
        Order_itemExample order_itemExample=new Order_itemExample();
        order_itemExample.createCriteria().andOrderIdEqualTo(oid);
        List<Order_item> order_items=order_itemMapper.selectByExample(order_itemExample);
        for (Order_item order_item : order_items) {   //获取订单和课程关系
            lessons.add(lessonServiceImpl.selectByLid(order_item.getlId()));   //把查询到的课程放到lessons里面
        }
         return lessons;
    }
}
