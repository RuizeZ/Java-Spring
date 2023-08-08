package com.imruize.spring6.tx;

import com.imruize.spring6.tx.config.SpringConfig;
import com.imruize.spring6.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnno {
    @Test
    public void testTxAllAnno(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController bookController = applicationContext.getBean("bookController", BookController.class);
        bookController.checkout(new Integer[]{1,2}, 1);
    }
}
