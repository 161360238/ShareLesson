package com.pdsu.service;

import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.User;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/19
 * @Description: com.pdsu.service
 * @version: 1.0
 */
public interface StudentService {
    /**
     * 学生关注老师
     *
     * @param sid
     * @param tid
     * @return
     */
    int watchTeacher(String sid, String tid);


    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     */
    public User selectUserById(String id);

    /**
     * 统计已经关注的老师有多少个
     *
     * @param uid
     * @return
     */
    int countWatchTeacher(String uid);

    /**
     * 查询已经关注老师的信息
     * @param sid
     * @return
     */
    List<User> selectWatchTeacher(String sid);

    /**
     * 学生取消关注老师
     * @param sid
     * @param tid
     * @return
     */
    int cancelWatch(String sid, String tid);

    /**
     * 学生提交成为老师申请
     * @param sid
     * @param text
     * @return
     */
    int submitExam(String sid, String text);

    /**
     * 学生查看自己的课程
     * @param getuId
     * @param condition
     * @return
     */
    List<Lesson> selectLessonBySid(String getuId, int condition);
}
