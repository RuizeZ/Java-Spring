package com.imruize.spring6.tx.service;

public interface CheckoutService {
    void checkout(Integer[] bookIds, Integer userId);
}
