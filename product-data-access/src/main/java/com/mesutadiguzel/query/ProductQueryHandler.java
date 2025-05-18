package com.mesutadiguzel.query;

import com.mesutadiguzel.entity.Product;
import com.mesutadiguzel.response.ProductResponse;
import com.mesutadiguzel.service.ProductService;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductQueryHandler {
    private final ProductService productService;

    public ProductQueryHandler(ProductService productService) {
        this.productService = productService;
    }

    @QueryHandler
    public List<ProductResponse> handle(FindProductsQuery findProductsQuery) {
        List<Product> responseProducts = productService.findAllProducts();
        List<ProductResponse> productResponses = new ArrayList<>();

        for (Product product : responseProducts) {
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(product, productResponse);
            productResponses.add(productResponse);
        }

        return productResponses;
    }
}
