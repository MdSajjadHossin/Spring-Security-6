package com.springboot.spring_security_6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private record Product(Integer productId, String productName, double price){}

    List<Product> products = new ArrayList<>(
            List.of(
                   new Product(1, "Smasung", 999.0),
                   new Product(2, "Think Pad", 2500.0),
                    new Product(3, "DSLR Camera", 850)
            )
    );

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return products;
    }

    @PostMapping("/addProducts")
    public Product addProduct(@RequestBody Product product){
        products.add(product);
        return product;
    }
}
