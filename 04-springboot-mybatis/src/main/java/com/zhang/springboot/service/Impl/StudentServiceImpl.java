package com.zhang.springboot.service.Impl;

import com.zhang.springboot.mapper.StudentDao;
import com.zhang.springboot.mapper.StudentMapper;
import com.zhang.springboot.model.Student;
import com.zhang.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zhangkj
 * @date 2019-05-05-12:38
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentDao studentDao;

    @Override

    public Student selectStudent(Integer id) {
        return studentMapper.selectByPrimaryKey(id) ;
    }

    @Override
    public Student selectStu(Integer id) {
        return studentDao.selectStu(id);
    }



    @Transactional
    @Override
    public int updateStudent(Student student) {

     //   int a = 10/0;

        return studentMapper.updateByPrimaryKey(student);
    }
}
