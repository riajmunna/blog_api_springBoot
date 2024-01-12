package com.blog.app.blogappapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name is Mandatory")
    private String name;
    @Email(message = "Email Must be valid") @NotEmpty(message = "Email is Mandatory")
    private String email;
    @NotEmpty(message = "Password is Mandatory")
    private String password;
    @NotEmpty(message = "Phone is Mandatory")
    private String phone;
    private String about;
}
