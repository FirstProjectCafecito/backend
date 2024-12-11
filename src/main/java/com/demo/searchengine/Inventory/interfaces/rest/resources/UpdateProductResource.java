package com.demo.searchengine.Inventory.interfaces.rest.resources;

public record UpdateProductResource(
        String name,
        double price,
        String brand,
        int quantity
) {
}
