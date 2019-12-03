package com.zhang.springboot.controller;

import com.zhang.springboot.model.Student;
import com.zhang.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Zhangkj
 * @date 2019-05-05-12:39
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/boot/select")
    @ResponseBody
    public Object studenta(){
        Student student = studentService.selectStudent(1);
        return student;
    }

    @RequestMapping("/boot/selectstu")
    @ResponseBody
    public Object studentdao(){
        Student student = studentService.selectStu(1);
        return student;
    }

    @RequestMapping("/boot/update")
    @ResponseBody
    public Object update(){

        Student student = new Student();
        student.setAge(55);
        student.setName("张克锦");
        student.setId(1);
        int a = studentService.updateStudent(student);

        //int b = 10/0;

        return a;
    }

}
