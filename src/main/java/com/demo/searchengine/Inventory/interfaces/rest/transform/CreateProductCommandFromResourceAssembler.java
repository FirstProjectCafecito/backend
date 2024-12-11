package com.demo.searchengine.Inventory.interfaces.rest.transform;

import com.demo.searchengine.Inventory.domain.model.commands.CreateProductCommand;
import com.demo.searchengine.Inventory.interfaces.rest.resources.CreateProductResource;

public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommandFromResource(CreateProductResource resource) {
        return new CreateProductCommand(
                resource.name(),
                resource.price(),
                resource.brand(),
                resource.quantity()
                );
    }
}
