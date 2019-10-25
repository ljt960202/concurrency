package com.leejt.concurrency.example.immutable;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName ImmutableExample1
 * @Description TODO
 * @Author Duplicator
 * @Date 2019/10/24 14:20
 * @Version 1.0
 **/
@Slf4j
public class ImmutableExample3 {
    private final static ImmutableList list = ImmutableList.of(1,2,3);
    private final static ImmutableSet set = ImmutableSet.copyOf(list);
    private final static ImmutableMap<Integer,Integer> map = ImmutableMap.of(1,4,2,5,3,6);
    private final static ImmutableMap<Integer,Integer> map2 = ImmutableMap.<Integer,Integer>builder()
            .put(1,1).put(2,2).put(3,3).put(4,4).build();
    public static void main(String[] args) {
        //list.add(4);
        //set.add(4);
        //map.put(1,2);
        log.info("{}",map.get(1));
    }
}
