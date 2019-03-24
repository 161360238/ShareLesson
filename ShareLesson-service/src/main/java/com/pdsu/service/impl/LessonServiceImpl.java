package com.pdsu.service.impl;

import com.pdsu.mapper.LessonMapper;
import com.pdsu.mapper.User_lessonMapper;
import com.pdsu.pojo.*;
import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.LessonExample;
import com.pdsu.pojo.User;
import com.pdsu.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/17
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonMapper lessonMapper;

    @Autowired
    private User_lessonMapper user_lessonMapper;

    //条件：0：正在审核，1：（通过，成功开课）未开始，2：未审核通过，3：正在进行，4：已经结束，5：未开课成功,6:查询全部
    @Override
    public List<Lesson> getLessonByTeacherId(String tid,int condition) {
        List<Lesson> lessons = new ArrayList<>();
        LessonExample lessonExample = new LessonExample();

        if(condition==0){
            lessonExample.createCriteria().andTIdEqualTo(tid)
                    .andExamEqualTo(0);  //正在审核
        }else if(condition==1){
            lessonExample.createCriteria().andTIdEqualTo(tid)
                    .andExamEqualTo(5)                    //审核通过且开课成功
                    .andBeginTimeGreaterThan(new Date());  //未开始
        }else if(condition==2){
            lessonExample.createCriteria().andTIdEqualTo(tid)
                    .andExamEqualTo(2);  //未审核通过
        }else if(condition==3){
            lessonExample.createCriteria().andTIdEqualTo(tid)
                    .andExamEqualTo(1)                   //审核通过
                    .andBeginTimeLessThan(new Date());   //已经过了上课时间，正在进行
        }else if(condition==4){
            lessonExample.createCriteria().andTIdEqualTo(tid)
                    .andExamEqualTo(3);  //已经结束
        }else if(condition==5){
            lessonExample.createCriteria().andTIdEqualTo(tid)
                    .andExamEqualTo(4);  //未开课成功
        }else if(condition==6){
            lessonExample.createCriteria().andTIdEqualTo(tid);  //查询这个老师的全部课程
        }

        lessons = lessonMapper.selectByExample(lessonExample);

        if (lessons != null && lessons.size() > 0) {
            return lessons;
        }
        return null;
    }

    @Override
    public Lesson selectByLid(String lid) {
        Lesson lesson = lessonMapper.selectByPrimaryKey(lid);
        return lesson;
    }

    //
    @Override
    public List<Lesson> taskSelect() {

        LessonExample lessonExample = new LessonExample();
        lessonExample.createCriteria().andExamEqualTo(1)   //审核通过
                .andEndTimeLessThan(new Date()) //报名截止时间已过
                .andRemindEqualTo(0);   //未通知过

        List<Lesson> lessons = lessonMapper.selectByExample(lessonExample);

        return lessons;
    }

    @Override
    public List<String> selectUserByLesson(String lid) {
        User_lessonExample user_lessonExample=new User_lessonExample();
        user_lessonExample.createCriteria().andLIdEqualTo(lid);
        List<User_lesson> user_lessons=user_lessonMapper.selectByExample(user_lessonExample);
        List<String> uids=new ArrayList<>();
        for (User_lesson userLesson:user_lessons){
            uids.add(userLesson.getuId());
        }
        return uids;
    }

    @Override
    public int selectSignNum(Lesson lesson) {
        User_lessonExample user_lessonExample = new User_lessonExample();
        user_lessonExample.createCriteria().andLIdEqualTo(lesson.getlId());
        int signNum = user_lessonMapper.countByExample(user_lessonExample);  //统计已经报名人数
        return signNum;
    }


    @Override
    public int publishLesson(Lesson lesson, User user) {
        lesson.setlId(UUID.randomUUID().toString());//设置课程id
        lesson.settId(user.getuId());//老师Id
        lesson.setExam(0);//未审核
        int insert = lessonMapper.insert(lesson);
        return insert;
    }



}
