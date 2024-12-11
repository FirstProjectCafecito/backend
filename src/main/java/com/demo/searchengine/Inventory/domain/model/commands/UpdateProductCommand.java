package com.demo.searchengine.Inventory.domain.model.commands;

public record UpdateProductCommand(
        Long productId,
        String name,
        double price,
        String brand,
        int quantity
) {
}
