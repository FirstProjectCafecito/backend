package com.demo.searchengine.Inventory.interfaces.rest;

import com.demo.searchengine.Inventory.domain.model.aggregates.Product;
import com.demo.searchengine.Inventory.domain.model.commands.DeleteProductCommand;
import com.demo.searchengine.Inventory.domain.model.queries.GetProductByTextQuery;
import com.demo.searchengine.Inventory.domain.services.ProductCommandService;
import com.demo.searchengine.Inventory.domain.services.ProductQueryService;
import com.demo.searchengine.Inventory.interfaces.rest.resources.CreateProductResource;
import com.demo.searchengine.Inventory.interfaces.rest.resources.DeleteProductResource;
import com.demo.searchengine.Inventory.interfaces.rest.resources.ProductResource;
import com.demo.searchengine.Inventory.interfaces.rest.resources.UpdateProductResource;
import com.demo.searchengine.Inventory.interfaces.rest.transform.CreateProductCommandFromResourceAssembler;
import com.demo.searchengine.Inventory.interfaces.rest.transform.DeleteProductCommandFromResourceAssembler;
import com.demo.searchengine.Inventory.interfaces.rest.transform.ProductResourceFromEntityAssembler;
import com.demo.searchengine.Inventory.interfaces.rest.transform.UpdateProductCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/products",produces = APPLICATION_JSON_VALUE)
@Tag(name = "Products", description = "Operation related to products")
public class ProductsController {
    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;

    public ProductsController(ProductCommandService productCommandService, ProductQueryService productQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;

    }

    @Operation(summary = "Create a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Product Created"),
            @ApiResponse(responseCode = "400",description = "Invalid input"),
    })
    @PostMapping
    public ResponseEntity<ProductResource> createProduct(@RequestBody CreateProductResource resource) {
        Optional<Product> product = productCommandService
                .handle(CreateProductCommandFromResourceAssembler.toCommandFromResource(resource));
        if(product.isEmpty()) {
            throw new IllegalArgumentException("Product creation failed");
        }
        var productCreated = product.get();

        return new ResponseEntity<>(ProductResourceFromEntityAssembler.toResourceFromEntity(productCreated),CREATED);
    }
    @Operation(summary = "Update a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Product Updated"),
            @ApiResponse(responseCode = "400",description = "Invalid input"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductResource> updateProduct(@PathVariable Long id, @RequestBody UpdateProductResource resource) {

        var product = productCommandService.handle(UpdateProductCommandFromResourceAssembler.toCommandFromResource(resource,id));
        if(product.isEmpty()) {
            throw new IllegalArgumentException("Product update failed");
        }
        var productUpdated = product.get();

        return new ResponseEntity<>(ProductResourceFromEntityAssembler.toResourceFromEntity(productUpdated),CREATED);

    }
    @Operation(summary = "Get products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Products Founded"),
            @ApiResponse(responseCode = "400",description = "Invalid input"),
    })
    @GetMapping("/page/{page}")
    public ResponseEntity<Page<ProductResource>> getProducts(@PathVariable int page) {
        Pageable pageable = PageRequest.of(page,5);
        Page<Product> products = productQueryService.handle(pageable);

        Page<ProductResource> productResources = products.map(ProductResourceFromEntityAssembler::toResourceFromEntity);
        return new ResponseEntity<>(productResources,CREATED);
    }
    @Operation(summary = "Search Products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Products Founded"),
            @ApiResponse(responseCode = "400",description = "Invalid input")
    })
    @GetMapping("/search/{text}")
    public ResponseEntity<Page<ProductResource>> searchProducts(
            @PathVariable String text,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productQueryService.handle(new GetProductByTextQuery(text), pageable);

        Page<ProductResource> productResources = products.map(ProductResourceFromEntityAssembler::toResourceFromEntity);

        return new ResponseEntity<>(productResources, CREATED);
    }

    @Operation(summary = "Delete products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Product Found"),
            @ApiResponse(responseCode = "400",description = "Invalid input"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteProductResource> deleteProduct(@PathVariable Long id) {
        DeleteProductCommand command = DeleteProductCommandFromResourceAssembler.toCommandFromResource(id);
        productCommandService.handle(command);
        DeleteProductResource response = new DeleteProductResource(id,"Product Deleted Successfully");
        return new ResponseEntity<>(response,ACCEPTED);
    }
}

