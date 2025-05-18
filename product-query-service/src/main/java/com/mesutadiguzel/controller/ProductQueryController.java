package com.mesutadiguzel.controller;

import com.mesutadiguzel.query.FindProductsQuery;
import com.mesutadiguzel.response.ProductResponse;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductQueryController {
    private final QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public ResponseEntity<?> findAllProducts() {
        FindProductsQuery findProductsQuery = new FindProductsQuery();
        List<ProductResponse> response = this.queryGateway.query(findProductsQuery, ResponseTypes.multipleInstancesOf(ProductResponse.class)).join();
        return ResponseEntity.ok(response);
    }
}
