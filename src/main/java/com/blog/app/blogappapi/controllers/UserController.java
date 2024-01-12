package com.blog.app.blogappapi.controllers;

import com.blog.app.blogappapi.entities.User;
import com.blog.app.blogappapi.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable(value = "id") Integer id){
        return userService.getUser(id);
    }

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping(value = "/user/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@Valid @RequestBody User user, @PathVariable(value = "id") Integer id){
        return userService.updateUser(user, id);
    }

    @DeleteMapping(value = "/user/{id}")
    public String deleteUser(@PathVariable(value = "id")Integer id){
        return userService.deleteUser(id);
    }
}
