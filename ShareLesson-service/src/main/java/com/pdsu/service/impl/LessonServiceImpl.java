package com.pdsu.service.impl;

import com.pdsu.mapper.LessonMapper;
import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.LessonExample;
import com.pdsu.pojo.User;
import com.pdsu.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Lesson lesson=lessonMapper.selectByPrimaryKey(lid);
        return lesson;
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
