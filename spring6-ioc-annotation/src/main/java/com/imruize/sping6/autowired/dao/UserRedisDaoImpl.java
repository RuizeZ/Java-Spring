package com.imruize.sping6.autowired.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserRedisDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("UserRedisDaoImpl");
    }
}
