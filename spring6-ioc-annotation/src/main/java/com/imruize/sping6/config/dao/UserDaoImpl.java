package com.imruize.sping6.config.dao;

import org.springframework.stereotype.Repository;

@Repository("theUserDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao running");
    }
}
