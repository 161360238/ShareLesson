package com.pdsu.service;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/16
 * @Description: com.pdsu.service
 * @version: 1.0
 */
public interface RedisService {
    /**
     * 判断是否存在
     *
     * @param key
     * @return
     */
    Boolean exits(String key);

    /**
     * 删除
     *
     * @param key
     * @return
     */
    Long del(String key);

    /**
     * 设置值
     *
     * @param key
     * @param value
     * @return
     */
    String set(String key, String value);

    /**
     * 取值
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * redis存活时间
     *
     * @param key
     * @param seconds
     * @return
     */
    Long expire(String key, int seconds);
}
