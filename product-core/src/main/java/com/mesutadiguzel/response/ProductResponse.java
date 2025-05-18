package com.mesutadiguzel.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductResponse {
    private String name;
    private BigDecimal price;
    private Integer stockQuantity;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
