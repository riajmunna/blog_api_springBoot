package com.blog.app.blogappapi.controllers;

import com.blog.app.blogappapi.entities.Post;
import com.blog.app.blogappapi.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("post/{user_id}/{category_id}")
    public Post createPost(@Valid @RequestBody Post post,
                           @PathVariable(name = "user_id") Integer user_id,
                           @PathVariable(name = "category_id") Integer category_id){
        return postService.createPost(post, user_id, category_id);
    }

    @PutMapping("post/{id}/{user_id}/{category_id}")
    public  Post updatePost(@Valid @RequestBody Post post,
                            @PathVariable(name = "id") Integer id,
                            @PathVariable(name = "user_id") Integer user_id,
                            @PathVariable(name = "category_id") Integer category_id
                            ){
        return postService.updatePost(post, id, user_id, category_id);
    }

    @GetMapping("post/{id}")
    public Post getPost(@PathVariable(name = "id") Integer id){
        return postService.getPost(id);
    }

    @GetMapping("posts")
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    @DeleteMapping("post/{id}")
    public String deletePost(@PathVariable(name = "id") Integer id){
        return postService.deletePost(id);
    }
}