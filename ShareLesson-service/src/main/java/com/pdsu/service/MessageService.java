package com.pdsu.service;

import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.Message;

import java.util.List;
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

    /**
     * 老师或者学生查看消息
     * @param uid
     * @param condition
     * @return
     */
    List<Message> selectMessage(String uid, int condition);

    /**
     * 标记消息为已读
     * @param mid
     * @return
     */
    int setMessageRead(String mid);
}
