package com.pdsu.service.impl;

import com.pdsu.mapper.Follow_perMapper;
import com.pdsu.mapper.UserMapper;
import com.pdsu.pojo.Follow_per;
import com.pdsu.pojo.Follow_perExample;
import com.pdsu.pojo.UserExample;
import com.pdsu.service.StudentService;
import com.pdsu.utils.CodecUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdsu.pojo.User;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/19
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private Follow_perMapper follow_perMapper;

    @Autowired
    private UserMapper userMapper;



    /**
     * 学生关注老师
     *
     * @param sid
     * @param tid
     * @return
     */
    @Override
    public int watchTeacher(String sid, String tid) {
        Follow_perExample follow_perExample = new Follow_perExample();
        follow_perExample.createCriteria().andSIdEqualTo(sid)
                .andTIdEqualTo(tid);
        List<Follow_per> follow_perList = follow_perMapper.selectByExample(follow_perExample);
        if (follow_perList != null && follow_perList.size() > 0) {
            return 2;
        }
        Follow_per follow_per = new Follow_per();
        String fid = CodecUtil.createUUID();
        follow_per.setFollowId(fid);
        follow_per.setsId(sid);
        follow_per.settId(tid);
        int result = follow_perMapper.insertSelective(follow_per);
        if (result > 0) {
            return 1;
        }
        return 0;
    }

    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     */
    public User selectUserById(String id) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUIdEqualTo(id);
        List<User> users = userMapper.selectByExample(userExample);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }
}
