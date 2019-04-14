package com.pdsu.task;

import com.pdsu.mapper.LessonMapper;
import com.pdsu.mapper.OrdersMapper;
import com.pdsu.mapper.User_lessonMapper;
import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.Orders;
import com.pdsu.pojo.User_lesson;
import com.pdsu.pojo.User_lessonExample;
import com.pdsu.service.LessonService;
import com.pdsu.service.MessageService;
import com.pdsu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/23
 * @Description: com.pdsu.task
 * 定时任务，通知老师、学生是否开课成功
 * @version: 1.0
 */
@Component
public class MyTask {

    @Autowired
    private LessonService lessonServiceImpl;

    @Autowired
    private User_lessonMapper user_lessonMapper;

    @Autowired
    private LessonMapper lessonMapper;

    @Autowired
    private MessageService messageServiceImpl;

    @Autowired
    private OrderService orderServiceImpl;

    @Autowired
    private OrdersMapper ordersMapper;


    /**
     * 通知开课情况消息
     */
    @Scheduled(cron = "*/10 * * * * ?")  //每10s执行一次
    public void myjob() {
        // System.out.println("task execing ...");

        List<Lesson> lessonList = lessonServiceImpl.taskSelect();
        //判断是否可以开课
        for (Lesson lesson : lessonList) {
            //查询已经报名的人数
            int signNum = lessonServiceImpl.selectSignNum(lesson);
            if (signNum < lesson.getMiniNum()) {  //报名人数 少于最少开课人数，开课失败
                try {
                    messageServiceImpl.insertNotice(lesson, 0);  //0表示开课失败
                    lesson.setRemind(1);  //设置状态为已经通知
                    lessonMapper.updateByPrimaryKeySelective(lesson);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    messageServiceImpl.insertNotice(lesson, 1);  //1表示开课成功
                    lesson.setRemind(1);  //设置状态为已经通知
                    lessonMapper.updateByPrimaryKeySelective(lesson);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 判断订单是否超时
     */
    @Scheduled(cron = "*/3600 * * * * ?")  //每一个小时执行一次
    public void myjob2() {
        int count=0;
        //先查看所有未付款订单
        List<Orders> ordersList=orderServiceImpl.selectOrderCriteria(count);
        if(ordersList!=null&&ordersList.size()>0){
            Date time=new Date();
            for (Orders orders:ordersList) {
                Date date2=orders.getCreateTime();
                if(time.getTime()-date2.getTime() > 60*60*1000){   //超过半小时未付款，设置为超时订单
                    orders.setStatus(3);
                    ordersMapper.updateByPrimaryKey(orders);
                }
            }
        }
    }

}
