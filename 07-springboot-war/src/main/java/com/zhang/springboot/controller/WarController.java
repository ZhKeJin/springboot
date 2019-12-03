package com.zhang.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.spec.DSAGenParameterSpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhangkj
 * @date 2019-05-07-18:19
 */
@Controller
public class WarController {


    @ResponseBody
    @RequestMapping("/boot/json")
    public Object json(){

        Map<String,Object> map = new HashMap<String,Object>();

        map.put("name","zhangsan");
        map.put("id",111111);
        map.put("age",12);

        return map;

    }


    @RequestMapping("/boot/jsp")
    public String jsp(Model model){

        model.addAttribute("msg","I am a boy");

        return "index";

    }



}
