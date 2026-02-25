package com.blog.blog.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginDto {


    @NotBlank(message = "Username cannot be blank")
    public String username;

    @NotBlank(message = "Password cannot be blank")
    public String password;
}
