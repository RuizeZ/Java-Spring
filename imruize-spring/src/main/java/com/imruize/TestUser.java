package com.imruize;

import com.imruize.bean.AnnotationApplicationContext;
import com.imruize.bean.ApplicationContext;
import com.imruize.service.UserService;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationApplicationContext("com.imruize");
        UserService userService = (UserService) context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
