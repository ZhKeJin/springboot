package com.zhang.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Zhangkj
 * @date 2019-05-04-15:30
 */

@Controller
public class HelloController {

    @RequestMapping("/boot/hello")
    public @ResponseBody String Hello(){
        return "Hello.. hellospringBoot";
    }

}
