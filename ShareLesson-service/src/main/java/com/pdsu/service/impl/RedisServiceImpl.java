package com.pdsu.service.impl;

import com.pdsu.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/16
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Repository
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    Jedis jedis = null;

    @Override
    public Boolean exits(String key) {

        Object obj = redisTemplate.boundValueOps(key).get();
        if (obj != null)
            return true;
        else
            return false;
    }

    @Override
    public void del(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public String set(String key, String value) {
        this.redisTemplate.opsForValue().set(key,value);
        return null;
    }
    @Override
    public String get(String key) {
        String str = (String) redisTemplate.boundValueOps(key).get();
        return str;
    }
    @Override
    public Long expire(String key, int seconds) {
        String str = (String) redisTemplate.boundValueOps(key).get();
        redisTemplate.opsForValue().set(key, str, seconds, TimeUnit.SECONDS);
        return 1L;
    }
}
