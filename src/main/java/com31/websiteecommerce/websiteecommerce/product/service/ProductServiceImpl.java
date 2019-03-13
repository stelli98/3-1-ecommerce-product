package com31.websiteecommerce.websiteecommerce.product.service;

import com31.websiteecommerce.websiteecommerce.product.entity.Product;
import com31.websiteecommerce.websiteecommerce.product.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product product) {
        final Optional<Product> updateProduct= findById(product.getId());
        if(updateProduct.isPresent()){
            BeanUtils.copyProperties(product,updateProduct.get());
            productRepository.save(updateProduct.get());
            return updateProduct.get();
        }
        return null;
    }

    @Override
    public Product delete( Long id) {
        Optional<Product> product= findById(id);
        if(product.isPresent()){
            productRepository.delete(product.get());
            return product.get();
        }
        return null;
    }
}
