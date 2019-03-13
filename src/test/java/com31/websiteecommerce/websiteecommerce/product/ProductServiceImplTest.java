package com31.websiteecommerce.websiteecommerce.product;

import com31.websiteecommerce.websiteecommerce.product.model.Product;
import com31.websiteecommerce.websiteecommerce.product.repository.ProductRepository;
import com31.websiteecommerce.websiteecommerce.product.service.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.Customizer;
import java.util.Optional;

public class ProductServiceImplTest {
    private ProductServiceImpl productService;
    private ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        productRepository= Mockito.mock(ProductRepository.class);
        productService=new ProductServiceImpl(productRepository);
    }

    @Test
    public void createTest(){
        Product productA=new Product(Long.valueOf(1L),
                "Xiaomi",
                "Electronic",
                Long.valueOf(12000),
                12);
//        Product productB=new Product(Long.valueOf(1L),
//                "Xiaomi SE",
//                "Electronic",
//                Long.valueOf(15000),
//                38);
        Mockito.when(productRepository.save(productA)).thenReturn(productA);
        Product p= productService.create(productA);
        Assert.assertTrue(p !=null);

        Mockito.verify(productRepository,Mockito.times(1)).save(productA);
    }

    @Test
    public void findByIdTest(){
        Product productA=new Product(Long.valueOf(1),
                "Xiaomi",
                "Electronic",
                Long.valueOf(12000),
                12);

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(productA));
        Mockito.when(productRepository.findById(2L)).thenReturn(Optional.empty());

        Optional<Product> result= productService.findById(1L);
        Assert.assertTrue(result!=null);

//        productService.create(productA);
//        Optional<Product> searchProduct1= productService.findById(Long.valueOf(1));
//        Optional<Product> searchProduct2= productService.findById(Long.valueOf(13));
//        Assert.assertTrue("Must return Xiaomi Product Details", productA.equals(searchProduct1));
//        Assert.assertTrue("Can't find unregistered id",searchProduct2==null);
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
        Product updateProduct1= productService.update(new Product(Long.valueOf(1),"Xiomai","Handphone",Long.valueOf(27500),21));
        Product updateProduct2= productService.update(new Product(Long.valueOf(12),"Xiomai","Handphone",Long.valueOf(27500),21));

        Assert.assertTrue("Product name must change to xiomai",productA.getName().equals(updateProduct1.getName()));
        Assert.assertTrue("Product category must change to handphone",productA.getCategory().equals(updateProduct1.getCategory()));
        Assert.assertTrue("Product price must change to 27500",productA.getPrice()==updateProduct1.getPrice());
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
