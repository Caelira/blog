package com.blog.blog.service;

import com.blog.blog.model.AppUser;
import com.blog.blog.model.Blog;
import com.blog.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {


    private BlogRepository REPOSITORY;

    public BlogServiceImpl(BlogRepository REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    @Override
    public void saveBlog(Blog blog) {
        REPOSITORY.save(blog);
    }

    @Override
    public void deleteBlog(Blog blog) {
        REPOSITORY.delete(blog);
    }

    @Override
    public Blog findByTitle(String title) {
        return REPOSITORY.findByTitle(title);
    }

    @Override
    public void editBlog(Blog blog) {

    }

    @Override
    public List<Blog> findAll() {
        return REPOSITORY.findAll();
    }

    @Override
    public List<Blog> findAllByWriter(AppUser user) {
        return List.of();
    }

    @Override
    public Blog findById(Long id) {
        return REPOSITORY.findById(id).orElseThrow();
    }
}
