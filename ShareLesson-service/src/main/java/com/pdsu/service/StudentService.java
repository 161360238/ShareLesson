package com.pdsu.service;

import com.pdsu.pojo.User;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/19
 * @Description: com.pdsu.service
 * @version: 1.0
 */
public interface StudentService {
    /**
     * 学生关注老师
     * @param sid
     * @param tid
     * @return
     */
    int watchTeacher(String sid, String tid);


    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    public User selectUserById(String id);
}
