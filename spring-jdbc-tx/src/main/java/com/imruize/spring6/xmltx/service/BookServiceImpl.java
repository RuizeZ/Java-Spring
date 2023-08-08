package com.imruize.spring6.xmltx.service;

import com.imruize.spring6.xmltx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        Integer price = bookDao.getBookPriceByBookId(bookId);
        bookDao.updateStock(bookId);
        bookDao.updateUserBalance(userId, price);
    }
}
