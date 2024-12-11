package com.demo.searchengine.Inventory.domain.services;

import com.demo.searchengine.Inventory.domain.model.aggregates.Product;
import com.demo.searchengine.Inventory.domain.model.queries.GetProductByTextQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductQueryService {
    Page<Product> handle(Pageable pageable);
    Page<Product> handle(GetProductByTextQuery query, Pageable pageable);
}
