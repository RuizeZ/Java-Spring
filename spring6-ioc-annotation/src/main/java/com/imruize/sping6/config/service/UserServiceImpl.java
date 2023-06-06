package com.imruize.sping6.config.service;

import com.imruize.sping6.config.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("theUserService")
public class UserServiceImpl implements UserService {
//    不指定名字，根据属性名字注入
    @Resource
    private UserDao theUserDao;
    @Override
    public void add() {
        System.out.println("service running");
        theUserDao.add();
    }
}
