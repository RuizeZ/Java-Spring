package com.imruize.sping6.autowired;

import com.imruize.sping6.autowired.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserController userController = (UserController) context.getBean("userController");
        userController.add();
    }
}
