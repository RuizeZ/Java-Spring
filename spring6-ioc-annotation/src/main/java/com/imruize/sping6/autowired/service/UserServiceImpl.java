package com.imruize.sping6.autowired.service;

import com.imruize.sping6.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    //注入dao
//    @Autowired
//    private UserDao userDao;

//    private UserDao userDao;
//
//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    //构造方法注入
//    private UserDao userDao;
//
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }
    //形参注入
//    private UserDao userDao;
//    public UserServiceImpl(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }

    //使用两个注解根据名称注入
    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
    private UserDao userDao;


    @Override
    public void add() {
        System.out.println("service running");
        userDao.add();
    }
}
