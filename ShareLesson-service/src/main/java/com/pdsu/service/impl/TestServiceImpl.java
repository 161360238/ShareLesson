package com.pdsu.service.impl;

import com.pdsu.pojo.User;
import com.pdsu.mapper.UserMapper;
import com.pdsu.pojo.UserExample;
import com.pdsu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/15
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User login(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0)
            return users.get(0);
        else
            return null;
    }
}
