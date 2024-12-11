package com.demo.searchengine.Inventory.application.internal.queryservices;

import com.demo.searchengine.Inventory.domain.model.aggregates.Product;

import com.demo.searchengine.Inventory.domain.model.queries.GetProductByTextQuery;
import com.demo.searchengine.Inventory.domain.services.ProductQueryService;
import com.demo.searchengine.Inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {
    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> handle(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> handle(GetProductByTextQuery query, Pageable pageable) {
        return this.productRepository.findByNameStartingWithIgnoreCaseOrBrandStartingWithIgnoreCase(
                query.text(),
                query.text(),
                pageable
        );
    }


}
