package com.pdsu.service;

import com.pdsu.pojo.Classify;
import com.pdsu.pojo.Lesson;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/17
 * @Description: com.pdsu.service
 * @version: 1.0
 */
public interface LessonService {

    /**
     * 根据分类查询课程
     * @param classify
     * @param num
     * @return
     */
    List<Lesson> selectByClassify(Classify classify,int num);
}