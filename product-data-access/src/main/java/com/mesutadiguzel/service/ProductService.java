package com.mesutadiguzel.service;

import com.mesutadiguzel.entity.Product;

import java.util.List;

public interface ProductService {
    String createProduct(Product product);

    List<Product> findAllProducts();
}
