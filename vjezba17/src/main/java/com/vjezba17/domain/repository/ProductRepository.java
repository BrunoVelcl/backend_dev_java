package com.vjezba17.domain.repository;

import com.vjezba17.domain.entity.Product;
import com.vjezba17.domain.entity.TransactionIsolationLevel;

public interface ProductRepository {
    public Product addOrUpdate(Product product, TransactionIsolationLevel til);
    public Product findById(long id);

}
