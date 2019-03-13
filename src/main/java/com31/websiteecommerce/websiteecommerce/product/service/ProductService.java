package com31.websiteecommerce.websiteecommerce.product.service;

import com31.websiteecommerce.websiteecommerce.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product create(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    Product update(Product product);
    Product delete(Long id);
}
