package com.demo.searchengine.Inventory.interfaces.rest.transform;

import com.demo.searchengine.Inventory.domain.model.commands.DeleteProductCommand;
import com.demo.searchengine.Inventory.interfaces.rest.resources.DeleteProductResource;

public class DeleteProductCommandFromResourceAssembler {
    public static DeleteProductCommand toCommandFromResource(Long id) {
        return new DeleteProductCommand(
                id
        );
    }
}
