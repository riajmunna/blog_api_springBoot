package com.blog.app.blogappapi.repositories;

import com.blog.app.blogappapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
