package com.imruize.service.impl;

import com.imruize.anno.Bean;
import com.imruize.anno.Di;
import com.imruize.dao.UserDao;
import com.imruize.service.UserService;

@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service add");
        //调用dao方法
        userDao.add();
    }
}
