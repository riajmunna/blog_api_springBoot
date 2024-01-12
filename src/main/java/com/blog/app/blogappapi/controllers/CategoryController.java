package com.blog.app.blogappapi.controllers;

import com.blog.app.blogappapi.entities.Category;
import com.blog.app.blogappapi.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("categories")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("category/{id}")
    public Category getCategory(@PathVariable(value = "id") Integer id){
        return categoryService.getCategory(id);
    }

    @PostMapping("category")
    public Category createCategory(@Valid @RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @PutMapping("category/{id}")
    public Category updateCategory(@Valid @RequestBody Category category, @PathVariable(value = "id") Integer id){
        return categoryService.updateCategory(category,id);
    }

    @DeleteMapping("category/{id}")
    public String deleteCategory(@PathVariable(value = "id") Integer id){
        return categoryService.deleteCategory(id);
    }


}
