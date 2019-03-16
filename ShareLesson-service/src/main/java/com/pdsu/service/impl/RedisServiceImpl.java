package com.pdsu.service.impl;

import com.pdsu.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPool;
/**
 * @Auther: http://wangjie
 * @Date: 2019/3/16
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Repository
public class RedisServiceImpl implements RedisService {
    @Autowired
    private JedisPool jedisPool;

    @Override
    public Boolean exits(String key) {
        return jedisPool.getResource().exists(key);
        //return jedisPool.ex
}

    @Override
    public Long del(String key) {
        // TODO Auto-generated method stub
        return jedisPool.getResource().del(key);
    }

    @Override
    public String set(String key, String value) {
        // TODO Auto-generated method stub
        return jedisPool.getResource().set(key, value);
    }

    @Override
    public String get(String key) {
        // TODO Auto-generated method stub
        return jedisPool.getResource().get(key);
    }

    @Override
    public Long expire(String key, int seconds) {
        return jedisPool.getResource().expire(key, seconds);
    }
}
