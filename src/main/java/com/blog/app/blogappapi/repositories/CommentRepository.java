package com.blog.app.blogappapi.repositories;

import com.blog.app.blogappapi.entities.Comment;
import com.blog.app.blogappapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> getCommentsByUser(User user);
    List<Comment> getPostByUser(User user);
}
