package com31.websiteecommerce.websiteecommerce.product.service;

import com31.websiteecommerce.websiteecommerce.product.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    private ArrayList<Product> products=new ArrayList<>();

    @Override
    public Product create(Product product) {
        if(findById(product.getId())==null){
            products.add(product);
            return product;
        }
        return null;
    }

    @Override
    public Product findById(Long id) {
        for(Product p:products){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product update(Product product) {
        Product updateProduct= findById(product.getId());
        if(updateProduct!=null){
            BeanUtils.copyProperties(product,updateProduct);
            return updateProduct;
        }
        return null;
    }

    @Override
    public Product delete( Long id) {
        Product product= findById(id);
        if(product!=null){
            products.remove(product);
            return product;
        }
        return null;
    }
}
