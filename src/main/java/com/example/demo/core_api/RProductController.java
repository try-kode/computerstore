package com.example.demo.core_api;

import com.example.demo.model.Product;
import com.example.demo.request.CreateProductRequest;
import com.example.demo.request.UpdateProductRequest;
import com.example.demo.serviceImp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class RProductController {

    @Autowired
    ProductServiceImp productServiceImp;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CreateProductRequest createProductRequest){
        Product product = new Product();
        product.setProductCode(createProductRequest.getProductCode());
        product.setProductName(createProductRequest.getProductName());
        product.setDescription(createProductRequest.getDescription());
        product.setPrice(createProductRequest.getPrice());
        product.setDiscount(createProductRequest.getDiscount());
        product.setImage(createProductRequest.getImage());
        product.setCategoryId(createProductRequest.getCategoryId());
        product.setSubCategoryId(createProductRequest.getSubCategoryId());
        product.setStoreId(createProductRequest.getStoreId());

        productServiceImp.createProduct(product);
        return ApiResponseStructure.singleResponse("Created", product, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll(){
        List<Product> productList = productServiceImp.getAllProducts();
        return ApiResponseStructure.singleResponse("Success", productList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            Product product = productServiceImp.getProductById(id);
            return ApiResponseStructure.singleResponse("Success", product, HttpStatus.OK);
        } catch (Exception e){
            return ApiResponseStructure.singleResponse(e.getMessage(), null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateById(@PathVariable Long id, @RequestBody UpdateProductRequest updateProductRequest){
        try {
            Product product = productServiceImp.getProductById(id);
            product.setProductCode(updateProductRequest.getProductCode());
            product.setProductName(updateProductRequest.getProductName());
            product.setDescription(updateProductRequest.getDescription());
            product.setPrice(updateProductRequest.getPrice());
            product.setDiscount(updateProductRequest.getDiscount());
            product.setImage(updateProductRequest.getImage());
            product.setCategoryId(updateProductRequest.getCategoryId());
            product.setSubCategoryId(updateProductRequest.getSubCategoryId());
            productServiceImp.updateProductById(id, product);
            return ApiResponseStructure.singleResponse("Success", product, HttpStatus.CREATED);
        } catch (Exception e){
            return ApiResponseStructure.singleResponse(e.getMessage(), null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try {
            Product product = productServiceImp.deleteProductById(id);
            return ApiResponseStructure.singleResponse("Deleted", product, HttpStatus.OK);
        } catch (Exception e){
            return ApiResponseStructure.singleResponse(e.getMessage(), null, HttpStatus.NOT_FOUND);
        }
    }
}
