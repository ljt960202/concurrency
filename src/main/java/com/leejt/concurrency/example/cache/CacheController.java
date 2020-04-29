package com.leejt.concurrency.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName CacheController
 * @Description TODO
 * @Author Duplicator
 * @Date 2020/4/22 16:43
 * @Version 1.0
 **/
@Controller
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private RedisClient redisClient;

    @RequestMapping("/set")
    @ResponseBody
    public String set(String k ,String v) throws Exception{
        redisClient.set(k,v);
        return "success";
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(String k) throws Exception{
        return redisClient.get(k);
    }
}
