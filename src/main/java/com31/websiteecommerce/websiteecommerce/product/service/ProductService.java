package com31.websiteecommerce.websiteecommerce.product.service;

import com31.websiteecommerce.websiteecommerce.product.model.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product findById(Long id);
    List<Product> findAll();
    Product update(Product product);
    Product delete(Long id);
}
