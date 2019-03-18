package com.pdsu.service.impl;

import com.pdsu.mapper.LessonMapper;
import com.pdsu.pojo.Classify;
import com.pdsu.pojo.Lesson;
import com.pdsu.service.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/17
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Service
public class LessonServiceImpl implements LessonService {
    private LessonMapper lessonMapper;

    @Override
    public List<Lesson> selectByClassify(Classify classify, int num) {
        return null;
    }
}
