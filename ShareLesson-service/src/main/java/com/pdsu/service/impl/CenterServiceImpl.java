package com.pdsu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pdsu.mapper.CenterMapper;
import com.pdsu.mapper.ClassifyMapper;
import com.pdsu.mapper.LessonMapper;
import com.pdsu.mapper.UserMapper;
import com.pdsu.mypojo.PageResult;
import com.pdsu.pojo.*;
import com.pdsu.service.*;
import com.pdsu.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/17
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Service
public class CenterServiceImpl implements CenterService {

    @Autowired
    private CenterMapper centerMapper;

    @Autowired
    private ClassifyMapper classifyMapper;

    @Autowired
    private LessonMapper lessonMapper;

    @Autowired
    private RedisService redisServiceImpl;

    @Autowired
    private ClassifyService classifyServiceImpl;

    @Autowired
    private LessonService lessonServiceImpl;

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询首页信息
     *
     * @return
     */
    @Override
    public List<Center> selectCtener() {
        CenterExample centerExample = new CenterExample();
        return centerMapper.selectByExample(centerExample);
    }

    /**
     * 查询分类
     *
     * @return
     */
    @Override
    public List<Classify> selectClassify() {
        List<Classify> classifies = new ArrayList<>();
        String ids = redisServiceImpl.get("center:push");
        List<String> ids2 = JsonUtils.jsonToList(ids, String.class);
        for (int i = 0; i < ids2.size(); i++) {
            classifies.add(classifyMapper.selectByPrimaryKey(ids2.get(i)));
        }
        return classifies;
    }

    /**
     * 根据分类查询课程
     *
     * @param classifies
     * @return
     */
    @Override
    public Map<Classify, List<Lesson>> selectLessonByClassifys(List<Classify> classifies) {
        Map<Classify, List<Lesson>> message = new HashMap<>();
        for (int i = 0; i < classifies.size(); i++) {
            Classify classify = new Classify();
            classify = classifies.get(i);

            List<Lesson> list = this.selectLessonByClassifyId(classify.getClassifyId(), 6);

            if (list != null) {
                if (list.size() >= 6) {
                    list = list.subList(0, 6);
                } else if (list.size() >= 3 && list.size() < 6) {
                    list = list.subList(0, 3);
                }
                message.put(classify, list);
            }
        }
        return message;
    }

    /**
     * 根据分类id查询前n调记录
     *
     * @param id
     * @return
     */
    @Override
    public List<Lesson> selectLessonByClassifyId(String id, int n) {
        List<Lesson> lessons = new ArrayList<>();
        LessonExample lessonExample = new LessonExample();
        lessonExample.createCriteria().andClassifyIdEqualTo(id) //分类限制条件
                .andExamEqualTo(1);          //对状态进行限制，只查询审核通过和未过时课程
        lessonExample.setOrderByClause("begin_time ASC");
        lessons = lessonMapper.selectByExample(lessonExample);
        if (lessons.size() > 0) {
            //倒序删除，避免下标问题
            for (int i = lessons.size() - 1; i >= 0; i--) {
                Lesson lesson = lessons.get(i);
                lesson.setCurrentNum(lessonServiceImpl.selectSignNum(lesson));
                if (lesson.getBeginTime().getTime() < System.currentTimeMillis()) {
                    lesson.setExam(2);  //状态设置为已经过时
                    lessonMapper.updateByPrimaryKeySelective(lesson);
                    lessons.remove(i);
                }
            }
            if (lessons.size() >= n) {
                return lessons.subList(0, n);
            }
            return lessons;
        } else {
            return null;
        }
    }

    /**
     * 根据分类id查询
     *
     * @param id
     * @return
     */
    @Override
    public List<Lesson> selectLessonByClassifyId2(String id, int isCharge) {
        List<Lesson> lessons = new ArrayList<>();
        if (isCharge == 1) {
            LessonExample lessonExample = new LessonExample();
            lessonExample.createCriteria().andClassifyIdEqualTo(id) //分类限制条件
                    .andBeginTimeGreaterThan(new Date())   //开始时间在当前时间后
                    .andIschargeEqualTo(1)        //只查询收费课程
                    .andExamEqualTo(1);          //对状态进行限制，只查询审核通过和未过时课程
            lessonExample.setOrderByClause("begin_time ASC");
            lessons = lessonMapper.selectByExample(lessonExample);
        } else if (isCharge == 0) {
            LessonExample lessonExample = new LessonExample();
            lessonExample.createCriteria().andClassifyIdEqualTo(id) //分类限制条件
                    .andBeginTimeGreaterThan(new Date())   //开始时间在当前时间后
                    .andIschargeEqualTo(0)        //只查询免费课程
                    .andExamEqualTo(1);          //对状态进行限制，只查询审核通过和未过时课程
            lessonExample.setOrderByClause("begin_time ASC");
            lessons = lessonMapper.selectByExample(lessonExample);
        } else {
            //收费，免费全查
            LessonExample lessonExample = new LessonExample();
            lessonExample.createCriteria().andClassifyIdEqualTo(id) //分类限制条件
                    .andBeginTimeGreaterThan(new Date())   //开始时间在当前时间后
                    .andExamEqualTo(1);          //对状态进行限制，只查询审核通过和未过时课程
            lessonExample.setOrderByClause("begin_time ASC");
            lessons = lessonMapper.selectByExample(lessonExample);
        }
        return lessons;
    }

    /**
     * 根据父id查询课程
     *
     * @param pid
     * @return
     */
    @Override
    public List<Lesson> selectLessonByParentClassifyId(String pid, int isCharge) {
        //先根据父分类查询改分类下的子分类
        List<Classify> classifies = classifyServiceImpl.selectClassifyByPid(pid);
        List<Lesson> lessons = new ArrayList<>();   //存储全部的课程
        if (classifies != null && classifies.size() > 0) {
            for (int i = 0; i < classifies.size(); i++) {
                lessons.addAll(
                        this.selectLessonByClassifyId2(classifies.get(i).getClassifyId(), isCharge));
            }
        }
        return lessons;
    }

    @Override
    public int setPushLesson(String c1, String c2) {
        String cartKey = "center:push";
        List<String> strs = new ArrayList<>();
        strs.add(c1);
        strs.add(c2);
        String json = JsonUtils.objectToJson(strs);
        String ok = redisServiceImpl.set(cartKey, json);
        if (ok.equals("OK")) {
            return 1;
        }
        return 0;
    }

    /**
     * 首页推送老师信息
     *
     * @return
     */
    @Override
    public List<User> pushTeacher() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdentityEqualTo(1);  //身份为老师
        userExample.setOrderByClause("fans DESC");   //按照粉丝降序
        return userMapper.selectByExample(userExample);
    }

    @Override
    public PageResult findPage(Center center, int page, int rows) {

        PageHelper.startPage(page, rows);
        CenterExample example = new CenterExample();
        CenterExample.Criteria criteria = example.createCriteria();
        //-------
        Page<Center> mypage = (Page<Center>) centerMapper.selectByExample(example);
        return new PageResult(mypage.getTotal(), mypage.getResult());
    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            centerMapper.deleteByPrimaryKey(id.toString());
        }
    }

    @Override
    public void add(Center center) {
        center.setCenterId(UUID.randomUUID().toString());
        centerMapper.insertSelective(center);
    }

    @Override
    public void update(Center center) {
        centerMapper.updateByPrimaryKey(center);
    }

    @Override
    public Center findOne(String id) {
        return centerMapper.selectByPrimaryKey(id);
    }
}