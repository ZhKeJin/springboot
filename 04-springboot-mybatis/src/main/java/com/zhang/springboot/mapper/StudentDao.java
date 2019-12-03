package com.zhang.springboot.mapper;

import com.zhang.springboot.model.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Zhangkj
 * @date 2019-05-05-13:54
 */
@Mapper
public interface StudentDao {

    public Student selectStu(Integer id);

}
