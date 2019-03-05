package com31.websiteecommerce.websiteecommerce.product.controller;

import com31.websiteecommerce.websiteecommerce.product.model.Product;
import com31.websiteecommerce.websiteecommerce.product.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping(value = "/products/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping(value = "/products",
                 produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping(value = "/products",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping(value = "/products/{id}",
                   produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product delete(@PathVariable Long id){
        return productService.delete(id);
    }


}
