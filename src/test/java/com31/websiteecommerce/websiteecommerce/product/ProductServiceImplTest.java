package com31.websiteecommerce.websiteecommerce.product;

import com31.websiteecommerce.websiteecommerce.product.model.Product;
import com31.websiteecommerce.websiteecommerce.product.service.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

public class ProductServiceImplTest {
    private ProductServiceImpl productService;

    @Before
    public void setUp() throws Exception {
        productService=new ProductServiceImpl();
    }

    @Test
    public void createTest(){
        Product productA=new Product(Long.valueOf(1),
                "Xiaomi",
                "Electronic",
                Long.valueOf(12000),
                12);
        productService.create(productA);
        Product productB=new Product(Long.valueOf(1),
                "Xiaomi SE",
                "Electronic",
                Long.valueOf(15000),
                38);
        productService.create(productB);
        Assert.assertTrue("Array size must be 1", productService.findAll().size() == 1);
        Assert.assertFalse("Product can't have similar id",
                           productService.findById(productB.getId())== null);
    }

    @Test
    public void findByIdTest(){
        Product productA=new Product(Long.valueOf(1),
                "Xiaomi",
                "Electronic",
                Long.valueOf(12000),
                12);
        productService.create(productA);
        Optional<Product> searchProduct1= productService.findById(Long.valueOf(1));
        Optional<Product> searchProduct2= productService.findById(Long.valueOf(13));
        Assert.assertTrue("Must return Xiaomi Product Details", productA.equals(searchProduct1));
        Assert.assertTrue("Can't find unregistered id",searchProduct2==null);
    }

    @Test
    public void findAllTest(){
        Product productA=new Product(Long.valueOf(1),
                "Xiaomi",
                "Electronic",
                Long.valueOf(12000),
                12);
        productService.create(productA);
        Product productB=new Product(Long.valueOf(2),
                "Xiaomi SE",
                "Electronic",
                Long.valueOf(15000),
                38);
        productService.create(productB);
        Assert.assertTrue("Array size must be 2", productService.findAll().size()==2);

    }

    @Test
    public void updateTest(){
        Product productA=new Product(Long.valueOf(1),
                "Xiaomi",
                "Electronic",
                Long.valueOf(12000),
                12);
        productService.create(productA);
        Optional<Product> updateProduct1= productService.update(new Product(Long.valueOf(1),"Xiomai","Handphone",Long.valueOf(27500),21));
        Optional<Product> updateProduct2= productService.update(new Product(Long.valueOf(12),"Xiomai","Handphone",Long.valueOf(27500),21));

        Assert.assertTrue("Product name must change to xiomai",updateProduct1.get().getName().equals("Xiomai"));
        Assert.assertTrue("Product category must change to handphone",updateProduct1.get().getCategory().equals("Handphone"));
        Assert.assertTrue("Product price must change to 27500",updateProduct1.get().getPrice()==27500);
        Assert.assertTrue("Can't change the id",updateProduct2 == null);

    }

    @Test
    public void deleteTest(){

        Product productA=new Product(Long.valueOf(1),
                "Xiaomi",
                "Electronic",
                Long.valueOf(12000),
                12);
        productService.create(productA);

        Product productB=new Product(Long.valueOf(2),
                "Xiaomi SE",
                "Electronic",
                Long.valueOf(15000),
                38);
        productService.create(productB);

        Product productC=new Product(Long.valueOf(3),
                "Xiaomi SE",
                "Electronic",
                Long.valueOf(15000),
                38);
        productService.create(productC);

        Product deleteProduct=productService.delete(Long.valueOf(2));
        Assert.assertTrue("Can't find product with id=2",productService.findById(deleteProduct.getId())==null);
        Assert.assertTrue("Current list size is 2",productService.findAll().size()==2);
        Assert.assertTrue("Can't delete id if id isn't registered",productService.delete(Long.valueOf(12))==null);


    }
}
