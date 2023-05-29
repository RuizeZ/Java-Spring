package com.imruize.spring6.iocxml.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdbc {
    @Test
    public void demo1(){
        DruidDataSource  dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }
    @Test
    public void demo2(){
        ApplicationContext contest = new ClassPathXmlApplicationContext("bean-jdbc.xml");
        DruidDataSource druidDataSource = (DruidDataSource)contest.getBean("druidDataSource");
        System.out.println(druidDataSource.getUrl());
    }
}
