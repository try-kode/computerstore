package com.example.demo.core_api;

import com.example.demo.model.Category;
import com.example.demo.request.CategoryRequest;
import com.example.demo.serviceImp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
public class RCategoryController {

    @Autowired
    CategoryServiceImp categoryServiceImp;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CategoryRequest categoryRequest){
        Category category = new Category();
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setDescription(categoryRequest.getDescription());
        categoryServiceImp.createCategory(category);
        return ApiResponseStructure.singleResponse("Created", category, HttpStatus.CREATED);
    }
}
