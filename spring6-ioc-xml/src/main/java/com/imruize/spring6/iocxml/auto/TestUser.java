package com.imruize.spring6.iocxml.auto;

import com.imruize.spring6.iocxml.auto.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-auto.xml");
        UserController UserController = (UserController)context.getBean("userController", UserController.class);
        UserController.addUser();
    }
}
