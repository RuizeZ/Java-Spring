package com.imruize.spring6.tx;

import com.imruize.spring6.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class TestBookTx {
    @Autowired
    private BookController bookController;
    @Test
    public void testBuyBook(){
        bookController.checkout(new Integer[]{1,2}, 1);
    }
}
