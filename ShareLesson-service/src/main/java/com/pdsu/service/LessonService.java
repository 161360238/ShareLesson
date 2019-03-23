package com.pdsu.service;

import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.User;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/17
 * @Description: com.pdsu.service
 * @version: 1.0
 */
public interface LessonService {

    /**
     * 根据老师id 查询他发布的课程
     * @param tid
     * @return
     */
    List<Lesson> getLessonByTeacherId(String tid);

    /**
     * 根据课程id 查询课程
     * @param lid
     * @return
     */
    Lesson selectByLid(String lid);

    /**
     * 发布课程
     * @param lesson
     * @return
     */
    public int publishLesson(Lesson lesson, User user);


}
