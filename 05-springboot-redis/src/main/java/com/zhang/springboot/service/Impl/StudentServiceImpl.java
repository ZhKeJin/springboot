package com.zhang.springboot.service.Impl;

import com.zhang.springboot.mapper.StudentDao;
import com.zhang.springboot.mapper.StudentMapper;
import com.zhang.springboot.model.Student;
import com.zhang.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
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

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override

    //双重判断
    public /*synchronized*/ Student selectStudent(Integer id) {

        redisTemplate.setKeySerializer(new StringRedisSerializer());


        Student student = (Student) redisTemplate.opsForValue().get("studentkey");

        if (student == null) {

            synchronized (this) {

                student = (Student) redisTemplate.opsForValue().get("studentkey");
                if (student == null) {
                    student = studentMapper.selectByPrimaryKey(id);
                    redisTemplate.opsForValue().set("studentkey",student);
                    System.out.println("查询数据库。。。");
                }else{

                    System.out.println("查询缓存。。。。");
                }
            }


        }else{
            System.out.println("查询缓存。。。。");
        }

        return student;


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
