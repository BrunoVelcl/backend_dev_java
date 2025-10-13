package com.TransactionIsolationTest.domain.repository;

import com.TransactionIsolationTest.domain.entity.Product;
import com.TransactionIsolationTest.domain.entity.TransactionIsolationLevel;

public interface ProductRepository {
    public Product addOrUpdate(Product product, TransactionIsolationLevel til);
    public Product findById(long id);

}
