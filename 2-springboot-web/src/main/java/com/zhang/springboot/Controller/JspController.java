package com.zhang.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zhangkj
 * @date 2019-05-04-17:10
 */

@Controller
public class JspController {

    @GetMapping("/boot/jsp")
    public String index(Model model){

        model.addAttribute("msg","this is a bootjsp张克锦");

        return "index";
    }


}
