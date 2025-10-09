package com.product;

import com.product.application.ProductService;

public class Main {
    public static void main(String[] args) {
        ProductService ps = new ProductService();
        ps.run();
    }
}
// <mapping class="com.product.domain.entity.Product"/>
// koristiti merge za izmjene, persist za nove unose
// vratiti objekt koji vraća merge
//naći objekt po id-u prije brisanja

