package com.pdsu.service;

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
}
