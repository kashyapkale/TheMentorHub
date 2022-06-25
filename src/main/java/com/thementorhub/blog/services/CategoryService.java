package com.thementorhub.blog.services;

import com.thementorhub.blog.payloads.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
    //Create
    CategoryDto createCategory(CategoryDto categoryDto);
    //Update
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
    //Delete
    void deleteCategory(Integer categoryId);
    //Get
    CategoryDto getCategory(Integer categoryId);
    //Get ALl
    List<CategoryDto> getAllCategories();
}
