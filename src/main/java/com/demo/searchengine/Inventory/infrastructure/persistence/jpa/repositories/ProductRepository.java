package com.demo.searchengine.Inventory.infrastructure.persistence.jpa.repositories;

import com.demo.searchengine.Inventory.domain.model.aggregates.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long id);
    Page<Product> findAll(Pageable pageable);
    Page<Product> findByNameStartingWithIgnoreCaseOrBrandStartingWithIgnoreCase(String name, String brand, Pageable pageable);
}
