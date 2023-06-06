package com.imruize.sping6.config;

import com.imruize.sping6.config.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserConntrollerAnno {
    public static void main(String[] args) {
//        加载配置类实现
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController userController = (UserController) context.getBean("theUserController");
        userController.add();
    }
}
