package com.imruize.spring6.iocxml.ditest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-diarray.xml");
        //employee object
        Employee emp = (Employee)context.getBean("emp", Employee.class);
        emp.work();
    }
}
