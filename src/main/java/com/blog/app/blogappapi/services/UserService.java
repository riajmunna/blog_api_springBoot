package com.blog.app.blogappapi.services;

import com.blog.app.blogappapi.entities.User;
import com.blog.app.blogappapi.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
   User createUser(User user);
   User updateUser(User user, Integer userId);
   User getUser(Integer userId);
   List<User> getUsers();
   String deleteUser(Integer userId);
}
