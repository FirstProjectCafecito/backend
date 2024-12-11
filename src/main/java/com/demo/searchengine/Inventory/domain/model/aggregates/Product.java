package com.demo.searchengine.Inventory.domain.model.aggregates;

import com.demo.searchengine.Inventory.domain.model.commands.CreateProductCommand;
import com.demo.searchengine.Inventory.domain.model.commands.UpdateProductCommand;
import com.demo.searchengine.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Entity
@Getter
public class Product extends AuditableAbstractAggregateRoot<Product> {

    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    private double price;

    @NotBlank
    private String brand;

    @NotNull
    @Min(0)
    private int quantity;

    protected Product() {}

    public Product(CreateProductCommand command){
        this.name=command.name();
        this.price=command.price();
        this.brand=command.brand();
        this.quantity=command.quantity();
    }
    public void update(UpdateProductCommand command){
        this.name=command.name();
        this.price=command.price();
        this.brand=command.brand();
        this.quantity=command.quantity();
    }

}
