package com.thementorhub.blog.services.impl;

import com.thementorhub.blog.exceptions.ResourceNotFoundException;
import com.thementorhub.blog.models.Category;
import com.thementorhub.blog.payloads.CategoryDto;
import com.thementorhub.blog.payloads.UserDto;
import com.thementorhub.blog.repositories.CategoryRepo;
import com.thementorhub.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return this.mapper.map((this.categoryRepo.save(this.mapper.map(categoryDto, Category.class))),CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category" , "ID" , categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        return this.mapper.map((this.categoryRepo.save(category)),CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category" , "ID" , categoryId));
        this.categoryRepo.delete(category);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category" , "ID" , categoryId));
        return this.mapper.map(category,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> allCategories = this.categoryRepo.findAll();
        return allCategories.stream().map(category -> this.mapper.map(category,CategoryDto.class)).collect(Collectors.toList());
    }
}
