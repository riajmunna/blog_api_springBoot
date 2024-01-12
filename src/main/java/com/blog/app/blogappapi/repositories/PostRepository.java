package com.blog.app.blogappapi.repositories;

import com.blog.app.blogappapi.entities.Category;
import com.blog.app.blogappapi.entities.Post;
import com.blog.app.blogappapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
