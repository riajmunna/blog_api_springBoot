package com.blog.app.blogappapi.repositories;

import com.blog.app.blogappapi.entities.Category;
import com.blog.app.blogappapi.entities.Post;
import com.blog.app.blogappapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    @Query("SELECT p FROM Post p WHERE LOWER(p.title) LIKE LOWER(concat('%', :keyword, '%')) OR LOWER(p.content) LIKE LOWER(concat('%', :keyword, '%'))")
    List<Post> findByKeyword(@Param("keyword") String keyword);
}
