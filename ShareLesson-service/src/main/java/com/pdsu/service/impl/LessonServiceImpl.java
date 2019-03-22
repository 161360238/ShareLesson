package com.pdsu.service.impl;

import com.pdsu.mapper.LessonMapper;
import com.pdsu.pojo.Classify;
import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.LessonExample;
import com.pdsu.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}
