package com.leejt.concurrency.example.cache;

import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * @ClassName RedisClient
 * @Description TODO
 * @Author Duplicator
 * @Date 2020/4/22 15:45
 * @Version 1.0
 **/
@Configuration
public class RedisClient {

    @Resource(name = "jedisPool")
    private JedisPool jedisPool;

    public void set(String key,String value) throws Exception{
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.set(key,value);
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public String get(String key) throws Exception{
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            return jedis.get(key);
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }
}
