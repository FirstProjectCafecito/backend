package com.demo.searchengine.Inventory.domain.services;

import com.demo.searchengine.Inventory.domain.model.aggregates.Product;
import com.demo.searchengine.Inventory.domain.model.commands.CreateProductCommand;
import com.demo.searchengine.Inventory.domain.model.commands.DeleteProductCommand;
import com.demo.searchengine.Inventory.domain.model.commands.UpdateProductCommand;

import java.util.Optional;

public interface ProductCommandService {
    Optional<Product> handle(CreateProductCommand command);
    Optional<Product> handle(UpdateProductCommand command);
    void handle(DeleteProductCommand command);
}
