package com.redis.test;

import com.redis.dao.UserDao;

import com.redis.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/2/11.
 */
public class test {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:redis-context.xml");
        UserDao user = (UserDao)context.getBean("userDao");

        User u = new User();
        u.setId("1");
        u.setName("aaa");
        u.setPassword("bbbbbbbbbb");

        user.add(u);

        System.out.println(user.getUser("2").getName());
    }
}
