package com.mesutadiguzel.command;

import com.mesutadiguzel.entity.Product;
import com.mesutadiguzel.service.ProductService;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductCommandEventHandler {
    private final ProductService productService;

    public ProductCommandEventHandler(ProductService productService) {
        this.productService = productService;
    }

    @EventHandler
    public void handle(ProductCreatedEvent productCreatedEvent) {
        Product product = new Product();
        BeanUtils.copyProperties(productCreatedEvent, product);
        this.productService.createProduct(product);
    }
}
