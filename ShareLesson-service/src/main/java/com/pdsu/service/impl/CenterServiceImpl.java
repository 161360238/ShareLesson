package com.pdsu.service.impl;

import com.pdsu.mapper.CenterMapper;
import com.pdsu.mapper.ClassifyMapper;
import com.pdsu.mapper.LessonMapper;
import com.pdsu.pojo.*;
import com.pdsu.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/17
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Service
public class CenterServiceImpl implements CenterService {

    @Autowired
    private CenterMapper centerMapper;

    @Autowired
    private ClassifyMapper classifyMapper;

    @Autowired
    private LessonMapper lessonMapper;

    /**
     * 查询首页信息
     *
     * @return
     */
    @Override
    public List<Center> selectCtener() {
        CenterExample centerExample = new CenterExample();
        return centerMapper.selectByExample(centerExample);
    }

    /**
     * 查询分类
     *
     * @return
     */
    @Override
    public List<Classify> selectClassify() {
        ClassifyExample classifyExample = new ClassifyExample();
        classifyExample.createCriteria().andIsParentEqualTo(0);
        List<Classify> classifies = classifyMapper.selectByExample(classifyExample);
        return classifies;
    }

    /**
     * 根据分类查询课程
     *
     * @param classifies
     * @return
     */
    @Override
    public Map<Classify, List<Lesson>> selectLessonByClassifys(List<Classify> classifies) {
        Map<Classify, List<Lesson>> message = new HashMap<>();
        for (int i = 0; i < classifies.size(); i++) {
            Classify classify = new Classify();
            classify = classifies.get(i);
            List<Lesson> list = this.selectLessonByClassifyId(classify.getClassifyId(), 6);
            if (list != null) {
                message.put(classify, list);
            }
        }
        return message;
    }

    /**
     * 根据分类id查询前n调记录
     *
     * @param id
     * @return
     */
    @Override
    public List<Lesson> selectLessonByClassifyId(String id, int n) {
        List<Lesson> lessons = new ArrayList<>();
        LessonExample lessonExample = new LessonExample();
        lessonExample.createCriteria().andClassifyIdEqualTo(id) //分类限制条件
                .andExamEqualTo(1);          //对状态进行限制，只查询审核通过和未过时课程
        lessonExample.setOrderByClause("begin_time ASC");
        lessons = lessonMapper.selectByExample(lessonExample);
        if (lessons.size() > 0) {
            //倒序删除，避免下标问题
            for (int i = lessons.size() - 1; i >= 0; i--) {
                Lesson lesson = lessons.get(i);
                if (lesson.getBeginTime().getTime() < System.currentTimeMillis()) {
                    lesson.setExam(2);  //状态设置为已经过时
                    lessonMapper.updateByPrimaryKeySelective(lesson);
                    lessons.remove(i);
                }

            }
            if (lessons.size() >= n) {
                return lessons.subList(0, n);
            }
            return lessons;
        } else {
            return null;
        }
    }

    /**
     * 根据分类id查询
     *
     * @param id
     * @return
     */
    @Override
    public List<Lesson> selectLessonByClassifyId(String id) {
        List<Lesson> lessons = new ArrayList<>();
        LessonExample lessonExample = new LessonExample();
        lessonExample.createCriteria().andClassifyIdEqualTo(id) //分类限制条件
                .andBeginTimeGreaterThan(new Date())   //开始时间在当前时间后
                .andExamEqualTo(1);          //对状态进行限制，只查询审核通过和未过时课程
        lessonExample.setOrderByClause("begin_time ASC");
        lessons = lessonMapper.selectByExample(lessonExample);
        return lessons;
    }

}
