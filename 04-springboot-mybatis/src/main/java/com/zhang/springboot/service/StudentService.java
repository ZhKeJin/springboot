package com.zhang.springboot.service;

import com.zhang.springboot.model.Student;

/**
 * @author Zhangkj
 * @date 2019-05-05-12:37
 */
public interface StudentService {

    public Student selectStudent(Integer id);

    public Student selectStu(Integer id);

    public int updateStudent(Student student);

}
