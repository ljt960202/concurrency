package com.leejt.concurrency;

import com.leejt.concurrency.example.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName HttpInterceptor
 * @Description TODO
 * @Author Duplicator
 * @Date 2019/10/25 16:03
 * @Version 1.0
 **/
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {
    //接口请求之前的处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        return true;
    }

    //postHandle出现异常不走 afterCompletion异常和正常都走
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //super.afterCompletion(request, response, handler, ex);
        RequestHolder.remove();
        log.info("afterCompletion");
        return;
    }
}
