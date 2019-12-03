package com.zhang.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhang.springboot.model.Student;
import com.zhang.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhangkj
 * @date 2019-05-05-12:39
 */
@RestController
public class StudentController {


    //@Autowired
    @Reference//相当于<dubbo:reference id="xxx" interface="xxx.xx.xx">
    private StudentService studentService;

    @RequestMapping("/boot/select")
    public Object studenta(){
        Student student = studentService.selectStudent(1);
        return student;
    }

    @RequestMapping("/boot/update")
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
