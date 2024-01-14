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

    @PostMapping("comment/{user_id}/{post_id}")
    public Comment createComment(
            @Valid @RequestBody Comment comment,
            @PathVariable(name = "user_id") Integer user_id,
            @PathVariable(name = "post_id") Integer post_id
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
}
