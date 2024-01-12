package com.blog.app.blogappapi.services.impl;

import com.blog.app.blogappapi.entities.User;
import com.blog.app.blogappapi.exceptions.UserNotFoundException;
import com.blog.app.blogappapi.repositories.UserRepository;
import com.blog.app.blogappapi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Integer userId) {
        User user1 = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setAbout(user.getAbout());
        user1.setPassword(user.getPassword());
        user1.setPhone(user.getPhone());
        userRepository.save(user1);
        return user1;
    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));
        if (user != null){
            userRepository.deleteById(userId);
            return "User Deleted!! "+userId;
        }else{
            return "User Not Found!!";
        }
    }
}
