package com.pdsu.service;

import com.pdsu.pojo.User;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/19
 * @Description: com.pdsu.service
 * @version: 1.0
 */
public interface TeacherService {

    /**
     * 老师查看自己的粉丝
     * @param tid
     * @return
     */
    List<User> selectFansByTid(String tid);

    /**
     * 根据老师ID，查询老师个人信息
     * @param tid
     * @return
     */
    User selectTeacherByTid(String tid);

    /**
     * 根据老师id查询发布的活动个数
     * @param tid
     * @return
     */
    int selectActive(String tid);

    /**
     * 统计发布的课程个数
     * @param tid
     * @return
     */
    int selectLesson(String tid);
}
