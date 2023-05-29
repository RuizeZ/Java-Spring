package com.imruize.spring6.iocxml.auto.service;

import com.imruize.spring6.iocxml.auto.dao.UserDao;

public class UserServiceImpl implements UserService{
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private UserDao userDao;

    @Override
    public void addUserService() {
        System.out.println("UserService method");
        userDao.addUserDao();
    }
}
