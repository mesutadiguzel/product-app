package com.mesutadiguzel.aggregate;

import com.mesutadiguzel.command.CreateProductCommand;
import com.mesutadiguzel.command.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer stockQuantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        if (command.getName() == null || command.getName().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }

        if (command.getPrice() == null || command.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }

        if (command.getStockQuantity() == null || command.getStockQuantity() < 0) {
            throw new IllegalArgumentException("Stock quantity must be zero or positive");
        }

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
        BeanUtils.copyProperties(command, productCreatedEvent);
        AggregateLifecycle.apply(productCreatedEvent);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.productId = event.getProductId();
        this.name = event.getName();
        this.price = event.getPrice();
        this.stockQuantity = event.getStockQuantity();
    }
}
