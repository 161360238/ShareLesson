package com.pdsu.service;

import com.pdsu.pojo.Lesson;

import java.util.Map;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/22
 * @Description: com.pdsu.service
 * @version: 1.0
 */
public interface MessageService {

    /**
     * 发送短信验证码
     * @param phone
     * @return
     */
    Map<String, Object> messge(String phone);

    /**
     * 判断是否验证通过
     * @param phone
     * @param code
     * @return
     */
    boolean verification(String phone, String code);

    /**
     * 编辑信息，通知开课是否成功
     * @param lesson
     * @param i
     */
    int insertNotice(Lesson lesson, int i) throws Exception;
}
