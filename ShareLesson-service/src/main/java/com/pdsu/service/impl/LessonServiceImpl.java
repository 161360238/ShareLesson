package com.pdsu.service.impl;

import com.pdsu.mapper.LessonMapper;
import com.pdsu.mapper.User_lessonMapper;
import com.pdsu.pojo.*;
import com.pdsu.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<Lesson> getLessonByTeacherId(String tid) {
        List<Lesson> lessons = new ArrayList<>();
        LessonExample lessonExample = new LessonExample();
        lessonExample.createCriteria().andTIdEqualTo(tid);
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
}
