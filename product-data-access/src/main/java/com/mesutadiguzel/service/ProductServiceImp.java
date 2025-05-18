package com.mesutadiguzel.service;

import com.mesutadiguzel.entity.Product;
import com.mesutadiguzel.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public String createProduct(Product product) {
        return this.productRepository.save(product).getProductId();
    }

    @Override
    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }
}
