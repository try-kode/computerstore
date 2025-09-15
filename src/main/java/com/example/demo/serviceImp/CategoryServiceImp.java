package com.example.demo.serviceImp;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImp implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        category.setUuid(UUID.randomUUID().toString());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
    }

    @Override
    public Category updateCategoryById(Long id, Category category) {
        Category exist = categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
        exist.setCategoryName(category.getCategoryName());
        exist.setDescription(category.getDescription());
        exist.setModifiedDate(new Date());
        return categoryRepository.save(exist);
    }

    @Override
    public Category deleteCategoryById(Long id) {
        Category exist = categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
        categoryRepository.deleteById(id);
        return exist;
    }
}
