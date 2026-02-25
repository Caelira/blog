package com.blog.blog.service;

import com.blog.blog.model.AppUser;

import java.util.List;

public interface UserService {

    public AppUser findByUsername(String username);
    public List<AppUser> findAllUser();
    public void saveUser(AppUser appUser);
    public void deleteUser(AppUser appUser);

}
