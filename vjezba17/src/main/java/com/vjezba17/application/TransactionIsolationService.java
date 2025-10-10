package com.vjezba17.application;

import com.vjezba17.domain.entity.TransactionIsolationLevel;
import com.vjezba17.domain.repository.ProductRepository;
import com.vjezba17.infrastructure.ProductRepositoryImpl;

import java.math.BigDecimal;

public class TransactionIsolationService  {

    public void run() {
        ProductRepository pr = new ProductRepositoryImpl();
        var proizvod = pr.findById(1);
        proizvod.setPrice(BigDecimal.valueOf(645.99));
        pr.addOrUpdate(proizvod, TransactionIsolationLevel.READ_COMMITTED);
        System.out.println(pr.findById(1).getPrice());
        proizvod.setPrice(BigDecimal.valueOf(39.99));
        pr.addOrUpdate(proizvod, TransactionIsolationLevel.SERIALIZABLE);
        System.out.println(pr.findById(1).getPrice());
        proizvod.setPrice(BigDecimal.valueOf(80.99));
        pr.addOrUpdate(proizvod, TransactionIsolationLevel.READ_UNCOMMITTED);
        System.out.println(pr.findById(1).getPrice());
        proizvod.setPrice(BigDecimal.valueOf(99.99));
        pr.addOrUpdate(proizvod, TransactionIsolationLevel.REPEATABLE_READ);
        System.out.println(pr.findById(1).getPrice());


    }
}
