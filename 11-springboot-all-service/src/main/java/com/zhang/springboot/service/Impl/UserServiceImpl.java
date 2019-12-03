package com.zhang.springboot.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhang.springboot.mapper.UserMapper;
import com.zhang.springboot.model.User;
import com.zhang.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Zhangkj
 * @date 2019-05-09-14:47
 */
@Component
@Service //dubbo的注解 相当于<dubbo:service>
public class UserServiceImpl implements UserService {

    @Autowired(required = true)
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public int insertUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int delectUser(Integer id) {

        int i = userMapper.deleteByPrimaryKey(id);
        if (i > 0) {

            redisTemplate.delete(id);
        }

        return i;
    }

    @Override
    public int updateUser(User user) {
        int i = userMapper.updateByPrimaryKey(user);
        if (i > 0){
            redisTemplate.opsForValue().set(user.getId(),user);
        }

        return i;
    }

    @Override
    public List<User> getUserByPage(int startRow, int pageSize) {
        return userMapper.selectUserByPage(startRow,pageSize);
    }

    @Override
    public int getUserByTotal() {
        return userMapper.selectUserByTotal();
    }

    @Override
    public User getUserById(Integer id) {

        //redisTemplate.setKeySerializer(new StringRedisSerializer());
        User user = (User) redisTemplate.opsForValue().get(id);

        if(user == null ){

            synchronized (this){
                user = (User) redisTemplate.opsForValue().get(id);
                if(user == null){
                    user = userMapper.selectByPrimaryKey(id);
                    redisTemplate.opsForValue().set(id,user);
                }
            }
        }


        return user;
    }
}
