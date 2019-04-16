package com.pdsu.service.impl;

import com.pdsu.mapper.Follow_perMapper;
import com.pdsu.mapper.LessonMapper;
import com.pdsu.mapper.UserMapper;
import com.pdsu.mapper.User_lessonMapper;
import com.pdsu.pojo.*;
import com.pdsu.service.StudentService;
import com.pdsu.service.TeacherService;
import com.pdsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/19
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private Follow_perMapper follow_perMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentService studentServiceImpl;

    @Autowired
    private User_lessonMapper user_lessonMapper;

    @Autowired
    private LessonMapper lessonMapper;


    /**
     * 通过老师id查询 老师粉丝
     *
     * @param tid
     * @return
     */
    @Override
    public List<User> selectFansByTid(String tid) {
        Follow_perExample follow_perExample = new Follow_perExample();
        follow_perExample.createCriteria().andTIdEqualTo(tid);
        List<Follow_per> follow_pers = follow_perMapper.selectByExample(follow_perExample);
        List<User> fans = new ArrayList<>();
        if (follow_pers != null && follow_pers.size() > 0) {

            User user = new User();
            for (int i = 0; i < follow_pers.size(); i++) {
                user = studentServiceImpl.selectUserById(follow_pers.get(i).getsId());
                if (user != null) {
                    fans.add(user);
                }
            }
        }
        if (fans.size() > 0) {
            return fans;
        }
        return null;
    }

    /**
     * 根据用户ID，查询用户
     *
     * @param tid
     * @return
     */
    @Override
    public User selectTeacherByTid(String tid) {
        return userMapper.selectByPrimaryKey(tid);
    }

    /**
     * 查询已经发布的活动数
     *
     * @param tid
     * @return
     */
    @Override
    public int selectActive(String tid) {
        int count = 0;
        LessonExample lessonExample=new LessonExample();
        lessonExample.createCriteria().andTIdEqualTo(tid).andKindEqualTo(2);  //查询活动
        count = lessonMapper.countByExample(lessonExample);
        return count;
    }

    /**
     * 统计发布的课程个数
     * @param tid
     * @return
     */
    @Override
    public int selectLesson(String tid) {
        int count = 0;
        LessonExample lessonExample=new LessonExample();
        lessonExample.createCriteria().andTIdEqualTo(tid).andKindEqualTo(1);   //查询课程
        count = lessonMapper.countByExample(lessonExample);
        return count;
    }
}
