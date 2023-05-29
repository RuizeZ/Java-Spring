package com.imruize.spring6.iocxml.life;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");
        User user = (User) context.getBean("user");
        System.out.println("6. 对象创建完成");
        System.out.println(user);
        context.close();
    }
}
