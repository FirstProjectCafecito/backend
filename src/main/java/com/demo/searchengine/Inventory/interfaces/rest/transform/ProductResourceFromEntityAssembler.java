package com.demo.searchengine.Inventory.interfaces.rest.transform;

import com.demo.searchengine.Inventory.domain.model.aggregates.Product;
import com.demo.searchengine.Inventory.interfaces.rest.resources.ProductResource;

public class ProductResourceFromEntityAssembler {
    public static ProductResource toResourceFromEntity(Product entity) {
        return new ProductResource(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getBrand(),
                entity.getQuantity()
        );
    }
}
