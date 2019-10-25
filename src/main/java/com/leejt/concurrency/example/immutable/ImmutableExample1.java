package com.leejt.concurrency.example.immutable;


import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @ClassName ImmutableExample1
 * @Description TODO
 * @Author Duplicator
 * @Date 2019/10/24 14:20
 * @Version 1.0
 **/
@Slf4j
public class ImmutableExample1 {
    private final static Integer a =1;
    private final static String b ="2";
    private final static Map<Integer,Integer> map = Maps.newHashMap();
    static {
        map.put(1,21);
        map.put(2,22);
        map.put(3,23);
    }

    public static void main(String[] args) {
        map.put(1,1);
        log.info("{}",map.get(1));
    }
    private void test(final int a){
        //a=1;
    }
}
