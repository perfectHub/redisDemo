package com.redis.dao;

import com.redis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/2/11.
 */
@Component
public class UserDao {

    @Autowired
    private RedisTemplate redisTemplate;

    public void add(User user) {
        ValueOperations<String,User> valueops = redisTemplate.opsForValue();
        valueops.set(user.getId(),user);
    }

    public User getUser(String key) {
        ValueOperations<String,User> valueops = redisTemplate.opsForValue();
        User user = valueops.get(key);
        if(user == null){
            System.out.println("查询数据库。。。");
        }
        return user;
    }
}
