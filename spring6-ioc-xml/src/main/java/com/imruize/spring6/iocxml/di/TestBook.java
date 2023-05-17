package com.imruize.spring6.iocxml.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {
    @Test
    public void testSet(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_di.xml");
        Book book = (Book)context.getBean("book", Book.class);
        System.out.println(book);
    }
    @Test
    public void testConstructor(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_di.xml");
        Book book = (Book)context.getBean("bookCon", Book.class);
        System.out.println(book);
    }
}
