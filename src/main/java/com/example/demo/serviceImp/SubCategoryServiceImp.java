package com.example.demo.serviceImp;

import com.example.demo.model.SubCategory;
import com.example.demo.repository.SubCategoryRepository;
import com.example.demo.service.ISubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SubCategoryServiceImp implements ISubCategory {

    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Override
    public SubCategory createSubCategory(SubCategory subCategory) {
        subCategory.setUuid(UUID.randomUUID().toString());
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategory getSubCategoryById(Long subCategoryId) {
        return subCategoryRepository.findById(subCategoryId)
                .orElseThrow(()->new RuntimeException("subCategoryId: "+subCategoryId+" not found"));
    }

    @Override
    public SubCategory updateSubCategoryById(Long subCategoryId, SubCategory subCategory) {
        SubCategory curr = subCategoryRepository.findById(subCategoryId)
                .orElseThrow(()->new RuntimeException("subCategoryId: "+subCategoryId+" not found"));
        curr.setSubCategoryName(subCategory.getSubCategoryName());
        curr.setDescription(subCategory.getDescription());
        curr.setCategoryId(subCategory.getCategoryId());
        curr.setModifiedDate(new Date());
        return subCategoryRepository.save(curr);
    }

    @Override
    public SubCategory deleteSubCategoryById(Long subCategoryId) {
        SubCategory curr = subCategoryRepository.findById(subCategoryId)
                .orElseThrow(()->new RuntimeException("subCategoryId: "+subCategoryId+" not found"));
        subCategoryRepository.deleteById(subCategoryId);
        return curr;
    }

    @Override
    public List<SubCategory> getSubCategoriesByCategoryId(Long categoryId) {
        return subCategoryRepository.findByCategoryId(categoryId);
    }
}
