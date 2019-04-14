package com.pdsu.service;

import com.pdsu.mypojo.PageResult;
import com.pdsu.pojo.Center;
import com.pdsu.pojo.Classify;
import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.User;

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
     * 根据分类id查询(isCharge-->1:收费，0:免费,2:不做限制)
     * 分页查询
     * @param id
     * @return
     */
    public List<Lesson> selectLessonByClassifyId2(String id,int isCharge);

    /**
     * 根据父分类id查询课程(isCharge-->1:收费，0:免费)
     * 分页查询
     * @param pid
     * @return
     */
    List<Lesson> selectLessonByParentClassifyId(String pid,int isCharge);

    /**
     * 设置首页推送课程分类
     * @param c1
     * @param c2
     * @return
     */
    int setPushLesson(String c1, String c2);

    /**
     * 获取首页推送老师的信息
     * @return
     */
    List<User> pushTeacher();

    //导航分页
    PageResult findPage(Center center, int page, int rows);

    //批量删除
    void delete(Integer[] ids);

    //添加
    void add(Center center);

    //修改
    void update(Center center);

    Center findOne(String id);
}
