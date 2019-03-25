package com.pdsu.service.impl;

import com.pdsu.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
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

    Jedis jedis = null;

    @Override
    public Boolean exits(String key) {
        try {
            jedis = jedisPool.getResource();
            Boolean result = jedis.exists(key);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

    @Override
    public Long del(String key) {
        try {
            jedis = jedisPool.getResource();
            Long result = jedis.del(key);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0L;
    }

    @Override
    public String set(String key, String value) {
        try {
            jedis = jedisPool.getResource();
            String result = jedis.set(key, value);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    @Override
    public String get(String key) {

        try {
            jedis = jedisPool.getResource();
            String result = jedis.get(key);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    @Override
    public Long expire(String key, int seconds) {
        try {
            jedis = jedisPool.getResource();
            Long result = jedis.expire(key, seconds);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0L;
    }
}
