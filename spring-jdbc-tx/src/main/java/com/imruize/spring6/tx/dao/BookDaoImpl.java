package com.imruize.spring6.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Integer getBookPriceByBookId(Integer bookId) {
        String sql = "SELECT price FROM t_book WHERE book_id = ?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
        return price;
    }

    @Override
    public void updateStock(Integer bookId) {
        String sql = "UPDATE t_book SET stock = stock - 1 WHERE book_id = ?";
        jdbcTemplate.update(sql, bookId);

    }

    @Override
    public void updateUserBalance(Integer userId, Integer price) {
        String sql = "UPDATE t_user SET balance = balance - ? WHERE user_id = ?";
        jdbcTemplate.update(sql, price, userId);
    }
}
