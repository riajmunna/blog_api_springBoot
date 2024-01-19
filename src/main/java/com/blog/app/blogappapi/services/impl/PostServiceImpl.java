package com.blog.app.blogappapi.services.impl;

import com.blog.app.blogappapi.entities.Category;
import com.blog.app.blogappapi.entities.Post;
import com.blog.app.blogappapi.entities.User;
import com.blog.app.blogappapi.exceptions.UserNotFoundException;
import com.blog.app.blogappapi.repositories.CategoryRepository;
import com.blog.app.blogappapi.repositories.PostRepository;
import com.blog.app.blogappapi.repositories.UserRepository;
import com.blog.app.blogappapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Post getPost(Integer post_id) {
        return postRepository.findById(post_id).orElseThrow(()
                -> new UserNotFoundException("Post not found with ID: " + post_id));
    }

    @Override
    public List<Post> getPosts(Integer pageNumber, Integer pageSize, String sortBy) {
        int zeroBasedPageNumber = pageNumber - 1;
        Pageable pageable = PageRequest.of(zeroBasedPageNumber, pageSize, Sort.by(sortBy));
        Page<Post> pagePost = postRepository.findAll(pageable);
        List<Post> posts = pagePost.getContent();
        return pagePost.getContent();
    }

    @Override
    public Post createPost(Post post, Integer user_id, Integer category_id) {
        User user = userRepository.findById(user_id).orElseThrow(()
                -> new UserNotFoundException("User not found with ID: " + user_id));
        Category category = categoryRepository.findById(category_id).orElseThrow(()
                -> new UserNotFoundException("Category not found with ID: " + category_id));
        post.setUser(user);
        post.setCategory(category);
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post, Integer post_id, Integer user_id, Integer category_id) {
        Post post1 = postRepository.findById(post_id).orElseThrow(()
                -> new UserNotFoundException("Post not found with ID: " + post_id));
        User user = userRepository.findById(user_id).orElseThrow(()
                -> new UserNotFoundException("User not found with ID: " + user_id));
        Category category = categoryRepository.findById(category_id).orElseThrow(()
                -> new UserNotFoundException("Category not found with ID: " + category_id));
        post1.setTitle(post.getTitle());
        post1.setContent(post.getContent());
        post1.setImage(post.getImage());
        post1.setUser(user);
        post1.setCategory(category);
        post1.setDate(post.getDate());
        postRepository.save(post1);
        return post1;
    }

    @Override
    public String deletePost(Integer post_id) {
        Post post = postRepository.findById(post_id).orElseThrow(()
                -> new UserNotFoundException("Post not found with ID: " + post_id));
        postRepository.deleteById(post.getId());
        return "Deleted Successfully!";
    }

    @Override
    public List<Post> getPostByCategory(Integer category_id) {
        Category category = categoryRepository.findById(category_id).orElseThrow(()
                -> new UserNotFoundException("Post not found with category ID: " + category_id));
        return postRepository.findByCategory(category);
    }

    @Override
    public List<Post> getPostByUser(Integer user_id) {
        User user = userRepository.findById(user_id).orElseThrow(()
                -> new UserNotFoundException("Post not found with user ID: " + user_id));
        return postRepository.findByUser(user);
    }

    @Override
    public List<Post> searchPost(String keyword) {
        return postRepository.findByKeyword(keyword);
    }
}
