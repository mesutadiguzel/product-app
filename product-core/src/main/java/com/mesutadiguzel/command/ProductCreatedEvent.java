package com.mesutadiguzel.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductCreatedEvent {
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer stockQuantity;
}
