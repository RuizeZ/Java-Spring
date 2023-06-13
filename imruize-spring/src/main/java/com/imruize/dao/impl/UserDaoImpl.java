package com.imruize.dao.impl;

import com.imruize.anno.Bean;
import com.imruize.dao.UserDao;
@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao add");
    }
}
