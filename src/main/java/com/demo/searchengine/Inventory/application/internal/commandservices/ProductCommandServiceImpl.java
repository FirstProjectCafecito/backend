package com.demo.searchengine.Inventory.application.internal.commandservices;

import com.demo.searchengine.Inventory.domain.model.aggregates.Product;
import com.demo.searchengine.Inventory.domain.model.commands.CreateProductCommand;
import com.demo.searchengine.Inventory.domain.model.commands.DeleteProductCommand;
import com.demo.searchengine.Inventory.domain.model.commands.UpdateProductCommand;
import com.demo.searchengine.Inventory.domain.services.ProductCommandService;
import com.demo.searchengine.Inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {
    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> handle(CreateProductCommand command) {
        var product = new Product(command);
        var productCreated= productRepository.save(product);
        return Optional.of(productCreated);
    }

    @Override
    public Optional<Product> handle(UpdateProductCommand command) {
        var product = productRepository.findById(command.productId())
                .orElseThrow(()-> new RuntimeException("Product not found"));

        product.update(command);

        var productUpdated= productRepository.save(product);

        return Optional.of(productUpdated);
    }

    @Override
    public void handle(DeleteProductCommand command) {
        var product = productRepository.findById(command.productId())
                .orElseThrow(()-> new RuntimeException("Product not found"));

        productRepository.delete(product);
    }
}
