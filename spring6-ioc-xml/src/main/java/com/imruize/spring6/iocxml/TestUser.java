package com.imruize.spring6.iocxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext contect = new ClassPathXmlApplicationContext(("bean.xml"));
//        获取bean
//        根据id获取
        User user = (User)contect.getBean("user");
        System.out.println("根据id获取: " + user);
//        根据类型获取
        User user2 = contect.getBean(User.class);
        System.out.println("根据类型获取: " + user2);
//        根据id和类型获取
        User user3 = contect.getBean("user", User.class);
        System.out.println("根据id和类型获取: " + user3);
    }
}
