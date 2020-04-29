package com.leejt.concurrency.example.cache;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

/**
 * @ClassName RedisConfig
 * @Description TODO
 * @Author Duplicator
 * @Date 2020/4/22 10:12
 * @Version 1.0 **/
@Configuration
public class RedisConfig {

    @Bean(name="jedisPool")
    public JedisPool jedisPool(@Value("${jedis.host}") String host,
                               @Value("${jedis.port}") int port,
                               @Value("${jedis.password}") String password){
        return new JedisPool(new GenericObjectPoolConfig(), host, port, Protocol.DEFAULT_TIMEOUT, password);
    }
}
