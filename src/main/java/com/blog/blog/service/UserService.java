package com.blog.blog.service;

import com.blog.blog.model.User;

import java.util.List;

public interface UserService {

    public User findByUsername(String username);
    public List<User> findAllUser();
    public void saveUser(User user);
    public void deleteUser(User user);

}
