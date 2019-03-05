package com31.websiteecommerce.websiteecommerce.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id ;
    private String name;
    private String category;
    private Long price;
    private int qty;
}
