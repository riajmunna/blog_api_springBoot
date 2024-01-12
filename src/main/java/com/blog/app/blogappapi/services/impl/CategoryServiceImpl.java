package com.blog.app.blogappapi.services.impl;

import com.blog.app.blogappapi.entities.Category;
import com.blog.app.blogappapi.exceptions.UserNotFoundException;
import com.blog.app.blogappapi.repositories.CategoryRepository;
import com.blog.app.blogappapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category, Integer category_id) {
        Category category1 = categoryRepository.findById(category_id).orElseThrow(()
                -> new UserNotFoundException("Category not found with ID: " + category_id));
        category1.setTitle(category.getTitle());
        return categoryRepository.save(category1);
    }

    @Override
    public Category getCategory(Integer category_id) {
        return categoryRepository.findById(category_id).orElseThrow(()
                -> new UserNotFoundException("Category not found with ID: " + category_id));
    }

    @Override
    public String deleteCategory(Integer category_id) {
        Category category1 = categoryRepository.findById(category_id).orElseThrow(()
                -> new UserNotFoundException("Category not found with ID: " + category_id));
        if(category1 != null){
            categoryRepository.deleteById(category1.getId());
            return "Deleted Successfully ";
        }else{
            return "Please Try Again";
        }
    }
}
