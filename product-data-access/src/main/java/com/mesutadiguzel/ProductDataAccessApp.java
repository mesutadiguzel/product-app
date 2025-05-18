package com.mesutadiguzel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductDataAccessApp {
    public static void main(String[] args) {
        SpringApplication.run(ProductDataAccessApp.class, args);
    }
}
