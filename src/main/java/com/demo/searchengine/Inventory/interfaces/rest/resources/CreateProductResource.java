package com.demo.searchengine.Inventory.interfaces.rest.resources;

public record CreateProductResource(
        String name,
        double price,
        String brand,
        int quantity
) {
}
