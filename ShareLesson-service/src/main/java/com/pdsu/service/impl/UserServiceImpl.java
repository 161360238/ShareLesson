package com.pdsu.service.impl;

import com.pdsu.mapper.UserMapper;
import com.pdsu.pojo.User;
import com.pdsu.pojo.UserExample;
import com.pdsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/16
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername())
                .andPasswordEqualTo(user.getPassword());
        List<User> users=userMapper.selectByExample(userExample);
        if(users.size()>0){
            return  users.get(0);
        }
        return null;
    }
}
