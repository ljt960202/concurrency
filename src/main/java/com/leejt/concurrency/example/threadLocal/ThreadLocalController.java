package com.leejt.concurrency.example.threadLocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ThreadLocalController
 * @Description TODO
 * @Author Duplicator
 * @Date 2019/10/25 16:53
 * @Version 1.0
 **/
@Controller
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    @RequestMapping("/test")
    public Long test(){
        return RequestHolder.getId();
    }
}
