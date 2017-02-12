package com.redis.dao;

import com.redis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UserDao2 {

    @Autowired
    protected RedisTemplate<Serializable, Serializable> redisTemplate;

    public void saveUser(final User user) {
        redisTemplate.execute(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection connection) throws DataAccessException {

                connection.set(redisTemplate.getStringSerializer().serialize(user.getId() + ""),
                        redisTemplate.getStringSerializer().serialize(user.getName()));

                return null;
            }

        });
    }

    public User getUser(final String id) {
        return redisTemplate.execute(new RedisCallback<User>() {

            public User doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] key = redisTemplate.getStringSerializer().serialize(id + "");
                if (connection.exists(key)) {
                    byte[] value = connection.get(key);
                    String name = redisTemplate.getStringSerializer().deserialize(value);
                    User user = new User();
                    user.setName(name);
                    user.setId(id);
                    return user;
                }
                return null;
            }

        });
    }

}
