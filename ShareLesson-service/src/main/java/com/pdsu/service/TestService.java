package com.pdsu.service;

import com.pdsu.pojo.User;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/15
 * @Description: com.pdsu.service
 * @version: 1.0
 */
public interface TestService {
    void addUser(User user);
    User login(String username);
}
