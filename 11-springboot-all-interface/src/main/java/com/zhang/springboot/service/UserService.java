package com.zhang.springboot.service;

import com.zhang.springboot.model.User;

import java.util.List;

/**
 * @author Zhangkj
 * @date 2019-05-09-14:00
 */
public interface UserService {

    public int insertUser(User user);
    public int delectUser(Integer id);
    public int updateUser(User user);

    public List<User> getUserByPage(int startRow,int pageSize);

    public int getUserByTotal();

    public User getUserById(Integer id);


}
