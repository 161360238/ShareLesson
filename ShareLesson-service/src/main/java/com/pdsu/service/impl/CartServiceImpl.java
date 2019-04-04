package com.pdsu.service.impl;

import com.pdsu.mapper.ClassifyMapper;
import com.pdsu.pojo.Classify;
import com.pdsu.pojo.Lesson;
import com.pdsu.service.CartService;
import com.pdsu.service.ClassifyService;
import com.pdsu.service.LessonService;
import com.pdsu.service.RedisService;
import com.pdsu.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/21
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private RedisService redisServiceImpl;

    @Autowired
    private LessonService lessonServiceImpl;

    @Autowired
    private ClassifyMapper classifyMapper;

    @Override
    public int addCart(String lid, String uid, String cartKey) {

        //存储购物车存放的所有商品
        List<Lesson> lessonList = new ArrayList<>();

        //最终存储到redis中的key
        String key = cartKey + uid;
        if (redisServiceImpl.exits(key)) {
            String json = redisServiceImpl.get(key);
            if (json != null && !json.equals("")) {
                //把购物车取出
                lessonList = JsonUtils.jsonToList(json, Lesson.class);
                //判断是否已经存在这个商品
                for (Lesson lesson : lessonList) {
                    //如果已经存在于购物车里面
                    if (lesson.getlId().equals(lid)) {
                        //表示已经存在
                        return 0;
                    }
                }
            }
        }

        Lesson lesson = lessonServiceImpl.selectByLid(lid);
        lessonList.add(lesson);//把课程加入购物车
        //写入redis
        redisServiceImpl.set(key, JsonUtils.objectToJson(lessonList));
        //正常加入
        return 1;
    }

    @Override
    public Map<String, List<Lesson>> showCart(String uid, String cartKey) {
        String key = cartKey + uid;
        String json = redisServiceImpl.get(key);
        List<Lesson> lessons = JsonUtils.jsonToList(json, Lesson.class);
        Map<String, List<Lesson>> map = new HashMap<>();  //分类和该分类下的课程
        for (Lesson lesson : lessons) {
            List<Lesson> list;
            list = map.get(classifyMapper.selectByPrimaryKey(lesson.getClassifyId())
                    .getClassifyName());
            if (list != null && list.size() > 0) {
                list.add(lesson);
                map.put(classifyMapper.selectByPrimaryKey(lesson.getClassifyId())
                        .getClassifyName(), list);
            } else {
                list = new ArrayList<>();
                list.add(lesson);
                map.put(classifyMapper.selectByPrimaryKey(lesson.getClassifyId())
                        .getClassifyName(), list);
            }
        }
        //System.out.println(map);
        return map;
    }

    @Override
    public int delectCart(String uid, String cartKey, String lid) {
        //最终存储到redis中的key
        String key = cartKey + uid;
        String json = redisServiceImpl.get(key);
        List<Lesson> lessons = JsonUtils.jsonToList(json, Lesson.class);
        Lesson lesson = null;
        for (Lesson ls : lessons) {
            if (ls.getlId().equals(lid)) {
                lesson = ls;
            }
        }
        lessons.remove(lesson);
        String ok = redisServiceImpl.set(key, JsonUtils.objectToJson(lessons));
        if (ok.equals("OK")) {
            return 1;
        }
        return 0;
    }
}
