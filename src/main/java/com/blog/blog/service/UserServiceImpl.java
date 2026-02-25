package com.blog.blog.service;

import com.blog.blog.model.AppUser;
import com.blog.blog.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private final AppUserRepository REPOSITORY;


    public UserServiceImpl(AppUserRepository repository) {
        this.REPOSITORY = repository;
    }

    @Override
    public AppUser findByUsername(String username) {
        return REPOSITORY.findByUsername(username);
    }

    @Override
    public List<AppUser> findAllUser() {
        return REPOSITORY.findAll();
    }

    @Override
    public void saveUser(AppUser appUser) {
        REPOSITORY.save(appUser);
    }

    @Override
    public void deleteUser(AppUser appUser) {
        REPOSITORY.delete(appUser);
    }
}
