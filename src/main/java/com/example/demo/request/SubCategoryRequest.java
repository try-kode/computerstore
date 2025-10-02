package com.example.demo.request;

import lombok.Data;

@Data
public class SubCategoryRequest {

    private String subCategoryName;
    private String description;
    private Long categoryId;
}
