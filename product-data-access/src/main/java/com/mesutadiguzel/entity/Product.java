package com.mesutadiguzel.entity;


import jakarta.persistence.*;
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
@Entity
public class Product {
    @Id
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer stockQuantity;
    @Column(updatable = false)
    private LocalDateTime createAt;
    @Column(insertable = false)
    private LocalDateTime updateAt;

    @PreUpdate
    private void updateTimestamps() {
        this.updateAt = LocalDateTime.now();
    }

    @PrePersist
    private void createTimestamps() {
        this.createAt = LocalDateTime.now();
    }
}
