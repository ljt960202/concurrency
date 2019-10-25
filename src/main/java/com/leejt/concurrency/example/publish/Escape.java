package com.leejt.concurrency.example.publish;

import com.leejt.concurrency.annoations.NotRecommend;
import com.leejt.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Escape
 * @Description TODO
 * @Author Duplicator
 * @Date 2019/10/23 16:09
 * @Version 1.0
 **/
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape=0;
    public Escape(){
        new InnerClass();
    }
    private class InnerClass{
        public InnerClass(){
            log.info("{}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
