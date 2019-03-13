package com31.websiteecommerce.websiteecommerce.product.controller;

import com31.websiteecommerce.websiteecommerce.product.entity.Product;
import com31.websiteecommerce.websiteecommerce.product.model.ApiKey;
import com31.websiteecommerce.websiteecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin
    @GetMapping(value = "/products",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> findAll(ApiKey apiKey){
        return productService.findAll();
    }


    @CrossOrigin
    @GetMapping(value = "/products/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Product> findById(@PathVariable Long id, ApiKey apiKey){
        return productService.findById(id);
    }

    @CrossOrigin
    @PostMapping(value = "/products",
                 produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product create(@RequestBody Product product, ApiKey apiKey){
        return productService.create(product);
    }

    @CrossOrigin
    @PutMapping(value = "/products",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product update(@RequestBody Product product,ApiKey apiKey){
        return productService.update(product);
    }

    @CrossOrigin
    @DeleteMapping(value = "/products/{id}",
                   produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product delete(@PathVariable Long id, ApiKey apiKey){
        return productService.delete(id);
    }


}
