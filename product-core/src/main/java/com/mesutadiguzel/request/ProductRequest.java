package com.mesutadiguzel.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductRequest {
    @NotBlank(message = "Product name is required")
    @Size(min = 2, max = 50, message = "Product name must be between 2 and 50 characters long")
    private String name;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than zero")
    private BigDecimal price;

    @NotNull(message = "Stock quantity is required")
    @Min(value = 1, message = "Stock quantity must be at least 1")
    private Integer stockQuantity;

}