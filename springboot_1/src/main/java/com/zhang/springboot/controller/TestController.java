package com.zhang.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Zhangkj
 * @date 2019-12-03-19:57
 */

@Controller
public class TestController {

    @RequestMapping("/world")
    @ResponseBody
    public String hello(){
        return "springboot.....";
    }

    @RequestMapping("/boot/index")

    public String hello_1(){
        return "index";
    }
}
