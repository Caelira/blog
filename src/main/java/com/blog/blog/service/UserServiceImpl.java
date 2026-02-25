package com.blog.blog.service;

import com.blog.blog.model.User;
import com.blog.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private final UserRepository REPOSITORY;

    public UserServiceImpl(UserRepository repository) {
        REPOSITORY = repository;
    }

    @Override
    public User findByUsername(String username) {
        return REPOSITORY.findByUsername(username);
    }

    @Override
    public List<User> findAllUser() {
        return REPOSITORY.findAll();
    }

    @Override
    public void saveUser(User user) {
        REPOSITORY.save(user);
    }

    @Override
    public void deleteUser(User user) {
        REPOSITORY.delete(user);
    }
}
