package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface IProductService {

    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long productId);
    Product deleteProductById(Long productId);
    Product updateProductById(Long productId, Product product);
}
