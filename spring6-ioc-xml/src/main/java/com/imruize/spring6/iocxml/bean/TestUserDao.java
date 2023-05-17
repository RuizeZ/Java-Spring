package com.imruize.spring6.iocxml.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //根据类型获取bean
        UserDao userDao = (UserDao)context.getBean(UserDao.class);
        System.out.println(userDao);
        userDao.run();
    }
}
