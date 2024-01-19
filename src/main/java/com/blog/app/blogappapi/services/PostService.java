package com.blog.app.blogappapi.services;

import com.blog.app.blogappapi.entities.Post;

import java.util.List;

public interface PostService {
     Post getPost(Integer post_id);
     List<Post> getPosts(Integer pageNumber, Integer pageSize, String sortBy);
     Post createPost(Post post, Integer user_id, Integer category_id);
     Post updatePost(Post post, Integer post_id, Integer user_id, Integer category_id);
     String deletePost(Integer post_id);

     List<Post> getPostByCategory(Integer category_id);
     List<Post> getPostByUser(Integer user_id);
     List<Post> searchPost(String keyword);
}
