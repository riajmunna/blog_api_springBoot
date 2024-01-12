package com.blog.app.blogappapi.services;

import com.blog.app.blogappapi.entities.Category;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    List <Category> getCategories();

    Category updateCategory(Category category, Integer category_id);

    Category getCategory(Integer category_id);

    String deleteCategory(Integer category_id);

}
