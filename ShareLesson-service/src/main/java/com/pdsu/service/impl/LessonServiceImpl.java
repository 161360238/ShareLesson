package com.pdsu.service.impl;

import com.pdsu.mapper.LessonMapper;
import com.pdsu.mapper.Praise_userMapper;
import com.pdsu.mapper.User_lessonMapper;
import com.pdsu.pojo.*;
import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.LessonExample;
import com.pdsu.pojo.User;
import com.pdsu.service.LessonService;
import com.pdsu.utils.CodecUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/17
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonMapper lessonMapper;

    @Autowired
    private User_lessonMapper user_lessonMapper;

    @Autowired
    private Praise_userMapper praise_userMapper;

    //条件：0：正在审核，1：（通过，成功开课）未开始，2：未审核通过，3：正在进行，4：已经结束，5：未开课成功,6:查询全部
    @Override
    public List<Lesson> getLessonByTeacherId(String tid, int condition) {
        List<Lesson> lessons = new ArrayList<>();
        LessonExample lessonExample = new LessonExample();

        if (condition == 0) {
            lessonExample.createCriteria().andTIdEqualTo(tid)
                    .andExamEqualTo(0);  //正在审核
        } else if (condition == 1) {
            lessonExample.createCriteria().andTIdEqualTo(tid)
                    .andExamEqualTo(5)                    //审核通过且开课成功
                    .andBeginTimeGreaterThan(new Date());  //未开始
        } else if (condition == 2) {
            lessonExample.createCriteria().andTIdEqualTo(tid)
                    .andExamEqualTo(2);  //未审核通过
        } else if (condition == 3) {
            lessonExample.createCriteria().andTIdEqualTo(tid)
                    .andExamEqualTo(1)                   //审核通过
                    .andBeginTimeLessThan(new Date());   //已经过了上课时间，正在进行
        } else if (condition == 4) {
            lessonExample.createCriteria().andTIdEqualTo(tid)
                    .andExamEqualTo(3);  //已经结束
        } else if (condition == 5) {
            lessonExample.createCriteria().andTIdEqualTo(tid)
                    .andExamEqualTo(4);  //未开课成功
        } else if (condition == 6) {
            lessonExample.createCriteria().andTIdEqualTo(tid);  //查询这个老师的全部课程
        }

        lessons = lessonMapper.selectByExample(lessonExample);

        if (lessons != null && lessons.size() > 0) {
            return lessons;
        }
        return null;
    }

    @Override
    public Lesson selectByLid(String lid) {
        Lesson lesson = lessonMapper.selectByPrimaryKey(lid);
        return lesson;
    }

    //
    @Override
    public List<Lesson> taskSelect() {

        LessonExample lessonExample = new LessonExample();
        lessonExample.createCriteria().andExamEqualTo(1)   //审核通过
                .andEndTimeLessThan(new Date()) //报名截止时间已过
                .andRemindEqualTo(0);   //未通知过

        List<Lesson> lessons = lessonMapper.selectByExample(lessonExample);

        return lessons;
    }

    @Override
    public List<String> selectUserByLesson(String lid) {
        User_lessonExample user_lessonExample = new User_lessonExample();
        user_lessonExample.createCriteria().andLIdEqualTo(lid);
        List<User_lesson> user_lessons = user_lessonMapper.selectByExample(user_lessonExample);
        List<String> uids = new ArrayList<>();
        for (User_lesson userLesson : user_lessons) {
            uids.add(userLesson.getuId());
        }
        return uids;
    }

    @Override
    public int selectSignNum(Lesson lesson) {
        User_lessonExample user_lessonExample = new User_lessonExample();
        user_lessonExample.createCriteria().andLIdEqualTo(lesson.getlId());
        int signNum = user_lessonMapper.countByExample(user_lessonExample);  //统计已经报名人数
        return signNum;
    }


    @Override
    public int publishLesson(Lesson lesson, User user) {
        lesson.setlId(UUID.randomUUID().toString());//设置课程id
        lesson.settId(user.getuId());//老师Id
        lesson.setExam(0);//未审核
        lesson.setKind(1);//課程
        int insert = lessonMapper.insert(lesson);
        return insert;
    }

    /**
     * 点赞
     *
     * @param lId
     * @return
     */
    @Override
    public int addPraise(String lId, String uid) {
        Lesson lesson = lessonMapper.selectByPrimaryKey(lId);
        int num1 = 0, num2 = 0;
        if (lesson != null) {
            Praise_user praise_user = new Praise_user();
            praise_user.setRid(CodecUtil.createUUID());
            praise_user.setlTId(lId);
            praise_user.setuId(uid);
            num1 = praise_userMapper.insertSelective(praise_user);   //在用户点赞表里面插入数据
            if (num1 > 0) {
                lesson.setPraise(lesson.getPraise() + 1);
                num2 = lessonMapper.updateByPrimaryKeySelective(lesson);
                if (num2 > 0) {
                    return 2;    //表示点赞成功
                }
            } else {
                return 1;  //表示已经点赞，不能重复点赞
            }
        }
        return 0;  //未知异常
    }

    /**
     * 判断是否点赞
     *
     * @param lId
     * @param uid
     * @return
     */
    @Override
    public int isPrasie(String lId, String uid) {
        Praise_userExample praise_userExample = new Praise_userExample();
        praise_userExample.createCriteria().andUIdEqualTo(uid);
        List<Praise_user> praise_users = praise_userMapper.selectByExample(praise_userExample);
        if (praise_users != null && praise_users.size() > 0) {
            return 1;    //已经点赞
        } else {
            return 0;   //还没有点赞
        }
    }

    /**
     * 取消点赞
     *
     * @param lId
     * @param uid
     * @return
     */
    @Override
    public int deletePraise(String lId, String uid) {
        Lesson lesson = lessonMapper.selectByPrimaryKey(lId);
        int num1 = 0, num2 = 0;
        int result = 0;
        if (lesson != null) {
            int num = this.isPrasie(lId, uid);
            if (num == 1) {  //取消的前提是已经点赞
                Praise_userExample praise_userExample = new Praise_userExample();
                praise_userExample.createCriteria().andUIdEqualTo(uid);
                List<Praise_user> praise_users = praise_userMapper.selectByExample(praise_userExample);
                if (praise_users != null && praise_users.size() > 0) {
                    result = praise_userMapper.deleteByPrimaryKey(praise_users.get(0).getRid());
                }
                if (result > 0) {
                    return 1;  //表示成功
                }
            }
        }
        return 0;  //未知异常
    }
}
