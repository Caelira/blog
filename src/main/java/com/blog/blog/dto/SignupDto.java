package com.blog.blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignupDto {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 50 ,message = "Character must be between 3-50 characters only")
    public String name;

    @NotBlank(message = "Username cannot be blank")
    public String username;

    @NotBlank(message = "Password cannot be blank")
    public String password;

    public SignupDto(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public SignupDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
