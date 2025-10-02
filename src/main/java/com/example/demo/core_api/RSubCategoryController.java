package com.example.demo.core_api;

import com.example.demo.model.SubCategory;
import com.example.demo.request.SubCategoryRequest;
import com.example.demo.serviceImp.SubCategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sub-category")
public class RSubCategoryController {

    @Autowired
    SubCategoryServiceImp subCategoryServiceImp;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody SubCategoryRequest subCategoryRequest){
        SubCategory subCategory = new SubCategory();
        subCategory.setSubCategoryName(subCategoryRequest.getSubCategoryName());
        subCategory.setDescription(subCategoryRequest.getDescription());
        subCategory.setCategoryId(subCategoryRequest.getCategoryId());
        subCategoryServiceImp.createSubCategory(subCategory);
        return ApiResponseStructure.singleResponse("Created", subCategory, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll(){
        List<SubCategory> subCategoryList = subCategoryServiceImp.getAllSubCategories();
        return ApiResponseStructure.singleResponse("Success", subCategoryList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        SubCategory subCategory = subCategoryServiceImp.getSubCategoryById(id);
        return ApiResponseStructure.singleResponse("Success", subCategory, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody SubCategoryRequest subCategoryRequest){
        SubCategory subCategory = subCategoryServiceImp.getSubCategoryById(id);
        subCategory.setSubCategoryName(subCategoryRequest.getSubCategoryName());
        subCategory.setDescription(subCategoryRequest.getDescription());
        subCategory.setCategoryId(subCategoryRequest.getCategoryId());
        subCategoryServiceImp.updateSubCategoryById(id, subCategory);
        return ApiResponseStructure.singleResponse("Updated", subCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        SubCategory subCategory = subCategoryServiceImp.getSubCategoryById(id);
        subCategoryServiceImp.deleteSubCategoryById(id);
        return ApiResponseStructure.singleResponse("Deleted", subCategory, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Object> findByCategoryId(@RequestParam Long categoryId){
        List<SubCategory> subCategoryList = subCategoryServiceImp.getSubCategoriesByCategoryId(categoryId);
        return ApiResponseStructure.singleResponse("Success", subCategoryList, HttpStatus.OK);
    }
}
