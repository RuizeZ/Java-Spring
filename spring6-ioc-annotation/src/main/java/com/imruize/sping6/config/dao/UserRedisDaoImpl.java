package com.imruize.sping6.config.dao;

import org.springframework.stereotype.Repository;

@Repository("theUserRedisDaoImpl")
public class UserRedisDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("UserRedisDaoImpl");
    }
}
