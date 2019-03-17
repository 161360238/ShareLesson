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

    Map<Classify, List<Lesson>> selectLessonByClassify(List<Classify> classifies);
}
