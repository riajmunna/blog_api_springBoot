package com.blog.app.blogappapi.controllers;

import com.blog.app.blogappapi.entities.Comment;
import com.blog.app.blogappapi.services.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("comment")
    public Comment createComment(
            @Valid @RequestBody Comment comment,
            @RequestParam() Integer user_id,
            @RequestParam() Integer post_id
    ){
        return commentService.createComment(comment, user_id, post_id);
    }

    @GetMapping("comments")
    public List<Comment> getComments(){
        return commentService.getComments();
    }

    @GetMapping("comment/{id}")
    public Comment getComment(@PathVariable(name = "id") Integer id){
        return commentService.getComment(id);
    }

    @PutMapping("comment/{id}")
    public Comment updateComment(
            @Valid
            @RequestBody Comment comment,
            @PathVariable(name = "id") Integer id,
            @RequestParam() Integer user_id,
            @RequestParam() Integer post_id
    ){
        return commentService.updateComment(comment, id, user_id, post_id);
    }

    @DeleteMapping("comment/{id}")
    public String deleteComment(@PathVariable(name = "id") Integer id){
        return commentService.deleteComment(id);
    }

    @GetMapping("comment/user/{id}")
    public List <Comment> getCommentsByUser(@PathVariable(name = "id") Integer id){
        return commentService.getCommentsByUser(id);
    }

    @GetMapping("comment/post/{id}")
    public List <Comment> getCommentsByPost(@PathVariable(name = "id") Integer id){
        return commentService.getCommentsByPost(id);
    }

    @GetMapping("comment/search/{keyword}")
    public List <Comment> getCommentsBySearch(@PathVariable(name = "keyword") String keyword){
        return commentService.getCommentsBySearch(keyword);
    }
}
