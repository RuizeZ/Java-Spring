package com.imruize.spring6.iocxml.bean;

public class PersonDaoImplt implements UserDao{
    @Override
    public void run() {
        System.out.println("person run...");
    }
}
