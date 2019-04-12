package com.pdsu.service.impl;

import com.pdsu.mapper.UserMapper;
import com.pdsu.mypojo.PageResult;
import com.pdsu.mypojo.Result;
import com.pdsu.pojo.User;
import com.pdsu.pojo.UserExample;
import com.pdsu.service.RedisService;
import com.pdsu.service.StudentService;
import com.pdsu.service.UserService;
import com.pdsu.utils.JsonUtils;
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

    @Autowired
    private RedisService redisServiceImpl;


    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername())
                .andPasswordEqualTo(user.getPassword());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @Override
    public int regist(User user) {
        //先判断用户是否已经存在
        String username = user.getUsername();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0) {
            return 2;
        }
        int result = userMapper.insertSelective(user);
        if (result > 0) {
            return 1;
        }
        return 0;
    }

    /**
     * 通过token获取用户
     *
     * @param token
     * @return
     */
    @Override
    public Result getUserByToken(String token) {
        Result result = new Result();
        String json = redisServiceImpl.get(token);

        if (json != null && !json.equals("")) {
            User user = JsonUtils.jsonToPojo(json, User.class);
            //可以把密码清空
            user.setPassword(null);
            result.setData(user);
            result.setCode("200");
            result.setMessage("获取用户信息成功");
        } else {
            result.setCode("201");
            result.setMessage("获取失败");
        }
        return result;
    }

    @Override
    public int updateuser(User user, String token) {
        int index = userMapper.updateByPrimaryKeySelective(user);
        if (index > 0) {   //修改成功
            user=userMapper.selectByPrimaryKey(user.getuId());
            String json = JsonUtils.objectToJson(user);
            //更新redis中的数据
            redisServiceImpl.set(token, json);
            return 1;
        }
        return 0;
    }

    @Override
    public PageResult findPage(User user, int page, int rows) {
        PageResult pageResult = new PageResult();
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        List<User> list = userMapper.selectByExample(example);
        pageResult.setRows(list);
        return pageResult;
    }
}
