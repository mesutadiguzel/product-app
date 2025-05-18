package com.mesutadiguzel.repository;

import com.mesutadiguzel.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
