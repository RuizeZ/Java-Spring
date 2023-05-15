package com.imruize.spring6;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    @Test
    public void testUserObject(){
        //加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //获取创建的对象
        User user = (User)context.getBean("user");
        //使用对象调用方法进行测试
        user.add();
    }
//    反射创建对象
    @Test
    public void testUserReflection() throws Exception {
//        get class object
        Class class1 = Class.forName("com.imruize.spring6.User");
//        create new object
        User user = (User) class1.getDeclaredConstructor().newInstance();
        System.out.println("reflection:" + user);
    }
}
