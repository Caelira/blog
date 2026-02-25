package com.blog.blog.service;

import com.blog.blog.model.AppUser;
import com.blog.blog.model.Blog;

import java.util.List;

public interface BlogService
{
    public void saveBlog(Blog blog);
    public void deleteBlog(Blog blog);
    public Blog findByTitle(String title);
    public void editBlog(Blog blog);
    public List<Blog> findAll();
    public List<Blog> findAllByWriter(AppUser user);
    public Blog findById(Long id);
}
