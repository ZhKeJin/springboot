package com.zhang.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhang.springboot.constants.Constants;
import com.zhang.springboot.model.User;
import com.zhang.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zhangkj
 * @date 2019-05-09-16:29
 */

@Controller
public class UserController {


    @Reference//dubbo注解，引用远程的dubbo服务接口
    private UserService userService;

    @GetMapping("/all/users")
    public String user(@RequestParam(value = "p",required = false) Integer p, Model model){

        if (null == p) {
            p=1;
        }
        int startRow = (p-1) * Constants.PAGE_SIZE;
        List<User> userList = userService.getUserByPage(startRow, Constants.PAGE_SIZE);
        int totalRows = userService.getUserByTotal();
        int totalPage = totalRows / Constants.PAGE_SIZE;

        int left = totalRows % Constants.PAGE_SIZE;
        if (left > 0) {
            totalPage+= 1;
        }


        model.addAttribute("userList",userList);
        model.addAttribute("p",p);
        model.addAttribute("totalPage",totalPage);



        //使用thymeleaf展示数据
        return "users";

    }

    @GetMapping("/all/user")
    public String toAddUser(){

        return "user";

    }

    @PostMapping("/all/user")
    public String addUser(User user){

        System.out.println("添加用户");
        System.out.println(user.toString());

        int i = userService.insertUser(user);
        System.out.println(i);
        return "redirect:/all/users";
    }


    @GetMapping("/all/user/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){

        User user = userService.getUserById(id);

        System.out.println(user.toString());

        model.addAttribute("user",user);

        return "user";

    }

    @PutMapping("/all/user")
    public String update(User user){

        System.out.println("修改用户");

        userService.updateUser(user);

        return "redirect:/all/users";

    }

    @DeleteMapping("/all/user/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){

        userService.delectUser(id);

        return "redirect:/all/users";
    }



}
