package com.zhang.springboot.controller;

import com.zhang.springboot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhangkj
 * @date 2019-05-08-21:38
 */
@Controller
public class ThymrleafController {

    @GetMapping("/boot/index")
    public String thymeleaf(Model model ){

     //   User user = new User();

        //往model中放入一个list
        List<User> userList = new ArrayList<User>();

        Map<String ,Object> usermap = new HashMap<>();

        User[] userArrays = new User[10];

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(1);
            user.setAge(23);
            user.setName("zhangsan");
            userList.add(user);
            usermap.put(String.valueOf(i),user);

            userArrays[i] = user;
        }

        User user1 = new User();

        user1.setId(4);
        user1.setAge(33);

        model.addAttribute("user",user1);

        model.addAttribute("sex",1);
        model.addAttribute("usermap",usermap);

        model.addAttribute("userArrays",userArrays);

        model.addAttribute("msg","我来了。。");
        model.addAttribute("userlist",userList);


        return "index";
    }

}
