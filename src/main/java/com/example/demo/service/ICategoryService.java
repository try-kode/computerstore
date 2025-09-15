package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryService {

    Category createCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
}
