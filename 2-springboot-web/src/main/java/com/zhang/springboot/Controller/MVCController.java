package com.zhang.springboot.Controller;

import com.zhang.springboot.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhangkj
 * @date 2019-05-04-16:41
 */

@RestController
public class MVCController{

    @RequestMapping(value = "/user")
    public User user(){

        User user = new User();
        user.setId(22);
        user.setName("张三");
        return user;
    }


    @PostMapping(value = "/user")
    public User user1(){

        User user = new User();
        user.setId(22);
        user.setName("张三");
        return user;
    }
}
