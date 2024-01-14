package com.blog.app.blogappapi.services;

import com.blog.app.blogappapi.entities.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment, Integer user_id, Integer post_id);
    Comment getComment(Integer comment_id);
    List<Comment> getComments();
    Comment updateComment(Comment comment, Integer comment_id, Integer user_id, Integer post_id);
    String deleteComment(Integer comment_id);
    List<Comment> getCommentsByUser(Integer user_id);
    List<Comment> getCommentsByPost(Integer post_id);
}
