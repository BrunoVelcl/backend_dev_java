package com.product.domain.repository;

import com.product.domain.entity.Product;

public interface ProductRepository {
    public Product addOrUpdateProduct(Product product);
    public void deleteProduct(Product product);

}
