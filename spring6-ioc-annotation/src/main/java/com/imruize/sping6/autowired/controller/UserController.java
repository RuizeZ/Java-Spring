package com.imruize.sping6.autowired.controller;

import com.imruize.sping6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    //注入service
//    @Autowired //根据类型找到实现类对象
//    private UserService userService;
    // set方法注入
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
    //构造方法注入
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    //形参注入
//    private UserService userService;
//
//    public UserController(@Autowired UserService userService) {
//        this.userService = userService;
//    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 只有一个有参构造 无注解
    private UserService userService;

    public void add(){
        System.out.println("controller running");
        userService.add();
    }
}
