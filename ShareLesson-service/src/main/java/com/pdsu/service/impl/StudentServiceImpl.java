package com.pdsu.service.impl;

//import com.pdsu.mapper.ApplyMapper;
import com.pdsu.mapper.Follow_perMapper;
import com.pdsu.mapper.UserMapper;
import com.pdsu.pojo.*;
import com.pdsu.service.StudentService;
import com.pdsu.utils.CodecUtil;
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
public class StudentServiceImpl implements StudentService {

    @Autowired
    private Follow_perMapper follow_perMapper;

    @Autowired
    private UserMapper userMapper;

    /*@Autowired
    private ApplyMapper applyMapper;*/


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

    /**
     * 统计学生关注的老师有多少个
     *
     * @param uid
     * @return
     */
    @Override
    public int countWatchTeacher(String uid) {
        Follow_perExample follow_perExample = new Follow_perExample();
        follow_perExample.createCriteria().andSIdEqualTo(uid);
        return follow_perMapper.countByExample(follow_perExample);
    }

    /**
     * 查询已经关注老师的信息
     *
     * @param sid
     * @return
     */
    @Override
    public List<User> selectWatchTeacher(String sid) {
        Follow_perExample follow_perExample = new Follow_perExample();
        follow_perExample.createCriteria().andSIdEqualTo(sid);
        List<Follow_per> follow_pers = follow_perMapper.selectByExample(follow_perExample);//查询关注记录
        List<User> teachers = new ArrayList<>();

        for (Follow_per follow_per : follow_pers) {   //根据关注记录查询老师信息，放到数组里面返回
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUIdEqualTo(follow_per.gettId());
            teachers.addAll(userMapper.selectByExample(userExample));
        }
        return teachers;
    }

    /**
     * 学生取消关注老师
     *
     * @param sid
     * @param tid
     * @return
     */
    @Override
    public int cancelWatch(String sid, String tid) {
        Follow_perExample follow_perExample = new Follow_perExample();
        follow_perExample.createCriteria().andSIdEqualTo(sid)
                .andTIdEqualTo(tid);
        int index = follow_perMapper.deleteByExample(follow_perExample);
        if (index > 0) {
            return 1;
        }
        return 0;
    }

    /**
     * 提交申请
     *
     * @param sid
     * @param text
     * @return
     */
    @Override
    public int submitExam(String sid, String text) {
       /* Apply apply = new Apply();

        apply.setaId(CodecUtil.createUUID());
        apply.setContent(text);
        apply.setuId(sid);
        apply.setStatus(0);
        int index = applyMapper.insertSelective(apply);
        if (index > 0) {
            return 1;
        }*/
        return 0;
    }
}
