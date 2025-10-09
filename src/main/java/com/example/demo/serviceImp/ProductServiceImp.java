package com.example.demo.serviceImp;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImp implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        product.setUuid(UUID.randomUUID().toString());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("productId: "+productId+" not found"));
    }

    @Override
    public Product deleteProductById(Long productId) {
        Product curr = productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("productId: "+productId+" not found"));
        productRepository.deleteById(productId);
        return curr;
    }

    @Override
    public Product updateProductById(Long productId, Product product) {
        Product curr = productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("productId: "+productId+" not found"));

        curr.setProductCode(product.getProductCode());
        curr.setProductName(product.getProductName());
        curr.setDescription(product.getDescription());
        curr.setPrice(product.getPrice());
        curr.setDiscount(product.getDiscount());
        curr.setImage(product.getImage());
        curr.setCategoryId(product.getCategoryId());
        curr.setSubCategoryId(product.getSubCategoryId());
        curr.setStatus(product.getStatus());
        curr.setModifiedDate(new Date());
        return productRepository.save(curr);
    }
}
