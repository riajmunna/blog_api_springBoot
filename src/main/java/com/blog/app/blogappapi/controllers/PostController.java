package com.blog.app.blogappapi.controllers;

import com.blog.app.blogappapi.entities.Post;
import com.blog.app.blogappapi.services.FileService;
import com.blog.app.blogappapi.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    FileService fileService;

    @Value("${project.image}")
    private String path;

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
    public List<Post> getPosts(
            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy
    ){
        return postService.getPosts(pageNumber, pageSize, sortBy);
    }

    @DeleteMapping("post/{id}")
    public String deletePost(@PathVariable(name = "id") Integer id){
        return postService.deletePost(id);
    }

    @GetMapping("post/user/{user_id}")
    public List<Post> getPostByUser(@PathVariable(name = "user_id") Integer user_id){
        return postService.getPostByUser(user_id);
    }

    @GetMapping("post/category/{category_id}")
    public List<Post> getPostByCategory(@PathVariable(name = "category_id") Integer category_id){
        return postService.getPostByCategory(category_id);
    }

    @PostMapping("post/image/upload/{post_id}")
    public Post uploadPostImage(
            @PathVariable(name = "post_id") Integer post_id,
            @RequestParam("image") MultipartFile image
    ) throws IOException {
        String filename = this.fileService.uploadImage(path, image);
        Post post = postService.getPost(post_id);
        post.setImage(filename);
        Post updatedPost = postService.updatePost(post, post_id, post.getUser().getId(),post.getCategory().getId());
        return updatedPost;
}

@GetMapping("post/search/{keyword}")
    public List<Post> getPostByKeyword(@PathVariable(name = "keyword") String keyword){
        return postService.searchPost(keyword);
    }
