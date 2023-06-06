package com.imruize.sping6.resource.controller;

import com.imruize.sping6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller("myUserController")
public class UserController {
//    根据名称进行注入
//    @Resource(name = "myUserService")
//    private UserService userService;
//    根据类型进行注入
    @Resource
    private UserService userService;
    public void add(){
        System.out.println("controller running");
        userService.add();
    }
}
