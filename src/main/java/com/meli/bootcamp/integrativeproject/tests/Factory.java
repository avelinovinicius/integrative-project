package com.meli.bootcamp.integrativeproject.tests;

import com.meli.bootcamp.integrativeproject.entity.Batch;
import com.meli.bootcamp.integrativeproject.entity.Product;
import com.meli.bootcamp.integrativeproject.enums.Category;

import java.time.LocalDate;

public class Factory {

    public static Product createProduct()
    {
          Product product = Product.builder().name("Peito de Frango")
                .currentTemperature(5.0)
                .minimalTemperature(7.0)
                .quantity(10)
                .dueDate(LocalDate.now())
                .price(18.0)
                .batch(new Batch())
                .category(Category.REFRIGERADO).build();
        return product;
    }
}
