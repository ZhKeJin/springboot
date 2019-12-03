package com.zhang.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhang.springboot.mapper.StudentMapper;
import com.zhang.springboot.model.Student;
import com.zhang.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Zhangkj
 * @date 2019-05-07-15:52
 */
@Service//表示dubbo的service 等价于<dubbo:service interface="xxx" ref="xxximpl">
@org.springframework.stereotype.Service//spring提供的注解，把该实现类变成spring容器中的bean对象
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;





    @Override
    public Student selectStudent(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Student selectStu(Integer id) {
        return null;
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateByPrimaryKey(student);
    }
}
