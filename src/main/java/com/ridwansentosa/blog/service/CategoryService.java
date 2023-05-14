package com.ridwansentosa.blog.service;

import com.ridwansentosa.blog.payload.CategoryDto;

import java.util.*;

public interface CategoryService {

    CategoryDto addCategory(CategoryDto categoryDto);

    CategoryDto getCategory(Long categoryId);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);

    void deleteCategory(Long categoryId);
}
