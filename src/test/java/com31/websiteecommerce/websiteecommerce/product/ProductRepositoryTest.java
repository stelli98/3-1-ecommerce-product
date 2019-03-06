package com31.websiteecommerce.websiteecommerce.product;


import com31.websiteecommerce.websiteecommerce.product.model.Product;
import com31.websiteecommerce.websiteecommerce.product.repository.ProductRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @After
    public void tearDown(){
        productRepository.deleteAll();
    }

    @Test
    public void saveTest(){
        Product productA=new Product();
        productA.setName("Xiaomi");
        productA.setCategory("Handphone");
        productA.setPrice(1_000_000L);
        Product save= productRepository.save(productA);
        Assert.assertNotNull("Product id A can't be null", productA.getId());
        Assert.assertTrue("Product name must be xiaomi", save.getName().equals("Xiaomi"));
        Assert.assertTrue("Product id must same with the saved one", productA.getId() == save.getId());

    }

    @Test
    public void findByIdTest(){
        Product productA=new Product();
        productA.setName("Xiaomi");
        productA.setCategory("Handphone");
        productA.setPrice(1_000_000L);
        Product save= productRepository.save(productA);
        Optional<Product> find=productRepository.findById(save.getId());
        Assert.assertTrue("Product name must show Xiaomi",save.getName().equals(find.get().getName()));
    }

    @Test
    public void findByAllTest(){
        Product productA=new Product();
        productA.setName("Xiaomi");
        productA.setCategory("Handphone");
        productA.setPrice(1_000_000L);
        Product saveProductA= productRepository.save(productA);


        Product productB=new Product();
        productB.setName("Mini Cooper");
        productB.setCategory("Car");
        productB.setPrice(12_000_000L);
        Product saveProductB= productRepository.save(productB);

        List<Product> find= productRepository.findAll();
        Assert.assertTrue("List size must be 2", find.size()==2);
    }

}
