package com.pdsu.service;

import com.pdsu.mypojo.Result;
import com.pdsu.pojo.User;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/16
 * @Description: com.pdsu.service
 * @version: 1.0
 */
public interface UserService {

    /**
     * 处理用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int regist(User user);

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    Result getUserByToken(String token);


    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateuser(User user,String token);
}
