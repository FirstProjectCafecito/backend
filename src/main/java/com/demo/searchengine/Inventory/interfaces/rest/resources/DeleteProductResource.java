package com.demo.searchengine.Inventory.interfaces.rest.resources;

public record DeleteProductResource(
        Long productId,
        String message
) {
}
