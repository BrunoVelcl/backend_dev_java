package com.product.application;

import com.product.domain.entity.Product;
import com.product.domain.repository.ProductRepository;
import com.product.infrastructure.ProductRepositoryImpl;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;

public class ProductService {
    public void run(){
        ProductRepository pr = new ProductRepositoryImpl();

        var p1 = pr.addOrUpdateProduct(new Product("Proizvod_1", BigDecimal.valueOf(499.99)));
        var p2 = pr.addOrUpdateProduct(new Product("Proizvod_2", BigDecimal.valueOf(99.99)));
        var p3 = pr.addOrUpdateProduct(new Product("Proizvod_3", BigDecimal.valueOf(59.99)));
        var p4 = pr.addOrUpdateProduct(new Product("Proizvod_4", BigDecimal.valueOf(49.99)));

        p3.setName("Izmjenjen_p3");
        p3.setPrice(BigDecimal.valueOf(66.99));
        pr.addOrUpdateProduct(p3);
        pr.deleteProduct(p2);

    }
}
