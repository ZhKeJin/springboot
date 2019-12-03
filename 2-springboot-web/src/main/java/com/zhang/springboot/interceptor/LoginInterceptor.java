package com.zhang.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Zhangkj
 * @date 2019-05-04-18:18
 */
public class LoginInterceptor implements HandlerInterceptor {


    /**
     * 进入controller之前执行的方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("进入登录拦截器。。");
        return true;
    }
}
