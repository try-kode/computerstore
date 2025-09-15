package com.example.demo.core_api;

import com.example.demo.model.Category;
import com.example.demo.request.CategoryRequest;
import com.example.demo.serviceImp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/")
    public ResponseEntity<Object> getAll(){
        List<Category> categories = categoryServiceImp.getAllCategories();
        if (categories != null){
            return ApiResponseStructure.singleResponse("Success", categories, HttpStatus.OK);
        } else {
            return ApiResponseStructure.singleResponse("Not found", null, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable Long id){
        Category category = categoryServiceImp.getCategoryById(id);
        if (category != null){
            return ApiResponseStructure.singleResponse("Success", category, HttpStatus.OK);
        } else {
            return ApiResponseStructure.singleResponse("Not found", null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest){
        Category category = categoryServiceImp.getCategoryById(id);
        if (category != null){
            category.setCategoryName(categoryRequest.getCategoryName());
            category.setDescription(categoryRequest.getDescription());
            categoryServiceImp.updateCategoryById(id, category);
            return ApiResponseStructure.singleResponse("Updated", category, HttpStatus.CREATED);
        } else {
            return ApiResponseStructure.singleResponse("Not found", null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Category category = categoryServiceImp.getCategoryById(id);
        if (category != null){
            categoryServiceImp.deleteCategoryById(id);
            return ApiResponseStructure.singleResponse("Deleted", category, HttpStatus.OK);
        } else {
            return ApiResponseStructure.singleResponse("Not found", null, HttpStatus.NOT_FOUND);
        }
    }
}
