package com.example.demo.service;

import com.example.demo.model.SubCategory;

import java.util.List;

public interface ISubCategory {
    SubCategory createSubCategory(SubCategory subCategory);
    List<SubCategory> getAllSubCategories();
    SubCategory getSubCategoryById(Long subCategoryId);
    SubCategory updateSubCategoryById(Long subCategoryId, SubCategory subCategory);
    SubCategory deleteSubCategoryById(Long subCategoryId);
    List<SubCategory> getSubCategoriesByCategoryId(Long categoryId);
}
