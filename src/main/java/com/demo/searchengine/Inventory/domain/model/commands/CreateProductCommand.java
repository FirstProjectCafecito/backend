package com.demo.searchengine.Inventory.domain.model.commands;

public record CreateProductCommand(
        String name,
        double price,
        String brand,
        int quantity
) {
}
