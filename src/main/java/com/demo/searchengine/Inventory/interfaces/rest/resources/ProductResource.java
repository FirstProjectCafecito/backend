package com.demo.searchengine.Inventory.interfaces.rest.resources;

public record ProductResource(
        Long id,
        String name,
        double price,
        String brand,
        int quantity
) {
}
