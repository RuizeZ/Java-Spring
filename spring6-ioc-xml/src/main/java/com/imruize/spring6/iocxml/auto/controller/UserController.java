package com.imruize.spring6.iocxml.auto.controller;

import com.imruize.spring6.iocxml.auto.service.UserService;

public class UserController {
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    public void addUser(){
        System.out.println("controller method");
        userService.addUserService();
    }
}
