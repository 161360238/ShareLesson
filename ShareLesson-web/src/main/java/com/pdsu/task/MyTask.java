package com.pdsu.task;

import com.pdsu.mapper.LessonMapper;
import com.pdsu.mapper.User_lessonMapper;
import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.User_lesson;
import com.pdsu.pojo.User_lessonExample;
import com.pdsu.service.LessonService;
import com.pdsu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
}
