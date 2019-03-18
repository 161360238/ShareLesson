package com.pdsu.service;

import com.pdsu.pojo.Center;
import com.pdsu.pojo.Classify;
import com.pdsu.pojo.Lesson;

import java.util.List;
import java.util.Map;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/16
 * @Description: com.pdsu.service
 * 首页信息显示
 * @version: 1.0
 */
public interface CenterService {

    /**
     * 显示导航栏信息
     * @return
     */
    List<Center> selectCtener();

    /**
     * 查询分类
     * @return
     */
    List<Classify> selectClassify();

    /**
     * 根据分类查询该分类下的课程，用于首页显示
     * @param classifies
     * @return
     */
    Map<Classify, List<Lesson>> selectLessonByClassifys(List<Classify> classifies);

    /**
     * 根据分类id查询该分类指定个数课程
     * @param id
     * @return
     */
    List<Lesson> selectLessonByClassifyId(String id,int n);

    /**
     * 根据分类id查询
     * @param id
     * @return
     */
    public List<Lesson> selectLessonByClassifyId(String id);

    /**
     * 根据父id查询课程
     * @param pid
     * @return
     */
    List<Lesson> selectLessonByParentClassifyId(String pid);
}
