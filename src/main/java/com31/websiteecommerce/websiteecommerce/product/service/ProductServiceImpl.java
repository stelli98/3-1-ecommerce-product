package com31.websiteecommerce.websiteecommerce.product.service;

import com31.websiteecommerce.websiteecommerce.product.model.Product;
import com31.websiteecommerce.websiteecommerce.product.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        if(findById(product.getId())==null){
            productRepository.save(product);
            return product;
        }
        return null;
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
    public Optional<Product> update(Product product) {
        Optional<Product> updateProduct= findById(product.getId());
        if(updateProduct.isPresent()){
            BeanUtils.copyProperties(product,updateProduct);
            return updateProduct;
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
