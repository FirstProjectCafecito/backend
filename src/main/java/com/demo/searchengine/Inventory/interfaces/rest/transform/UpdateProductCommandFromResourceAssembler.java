package com.demo.searchengine.Inventory.interfaces.rest.transform;

import com.demo.searchengine.Inventory.domain.model.commands.UpdateProductCommand;
import com.demo.searchengine.Inventory.interfaces.rest.resources.UpdateProductResource;

public class UpdateProductCommandFromResourceAssembler {
    public static UpdateProductCommand toCommandFromResource(UpdateProductResource resource,Long id) {
        return new UpdateProductCommand(
                id,
                resource.name(),
                resource.price(),
                resource.brand(),
                resource.quantity()
        );
    }
}
