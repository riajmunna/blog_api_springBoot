package com.blog.app.blogappapi.services.impl;

import com.blog.app.blogappapi.entities.Category;
import com.blog.app.blogappapi.entities.Comment;
import com.blog.app.blogappapi.entities.Post;
import com.blog.app.blogappapi.entities.User;
import com.blog.app.blogappapi.exceptions.UserNotFoundException;
import com.blog.app.blogappapi.repositories.CategoryRepository;
import com.blog.app.blogappapi.repositories.CommentRepository;
import com.blog.app.blogappapi.repositories.PostRepository;
import com.blog.app.blogappapi.repositories.UserRepository;
import com.blog.app.blogappapi.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @Override
    public Comment createComment(Comment comment, Integer user_id, Integer post_id) {
        User user = userRepository.findById(user_id).orElseThrow(()
                -> new UserNotFoundException("User not found with ID: " + user_id));
        Post post = postRepository.findById(post_id).orElseThrow(()
                -> new UserNotFoundException("Post not found with ID: " + post_id));
        comment.setPost(post);
        comment.setUser(user);
        return commentRepository.save(comment);
    }

    @Override
    public Comment getComment(Integer comment_id) {
        return commentRepository.findById(comment_id).orElseThrow(()
                -> new UserNotFoundException("Comment not found with ID: " + comment_id));
    }

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment updateComment(Comment comment, Integer comment_id, Integer user_id, Integer post_id) {
        return null;
    }

    @Override
    public String deleteComment(Integer comment_id) {
        return null;
    }

    @Override
    public List<Comment> getCommentsByUser(Integer user_id) {
        return null;
    }

    @Override
    public List<Comment> getCommentsByPost(Integer post_id) {
        return null;
    }
}
