package com.imruize.spring6.iocxml.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrders {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        Orders orders = (Orders) context.getBean("orders2");
        System.out.println(orders);
        Orders orders2 = (Orders) context.getBean("orders2");
        System.out.println(orders2);
    }
}
