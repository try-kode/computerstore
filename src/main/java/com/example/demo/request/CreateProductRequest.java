package com.example.demo.request;

import lombok.Data;

@Data
public class CreateProductRequest {

    private String productCode;
    private String productName;
    private String description;
    private Double price;
    private Double discount;
    private String image;
    private Long categoryId;
    private Long subCategoryId;
    private Long storeId;
    private String publisher;
}
