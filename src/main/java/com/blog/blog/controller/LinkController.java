package com.blog.blog.controller;

import com.blog.blog.dto.BlogDto;
import com.blog.blog.dto.SignupDto;
import com.blog.blog.model.AppUser;
import com.blog.blog.model.Blog;
import com.blog.blog.model.CustomUserDetails;
import com.blog.blog.service.BlogService;
import com.blog.blog.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LinkController {


    private UserService service;
    private BlogService blogService;

    public LinkController(UserService service, BlogService blogService) {
        this.service = service;
        this.blogService = blogService;
    }

    //show blog pg
    @GetMapping("/")
    public String showBlogs(@AuthenticationPrincipal CustomUserDetails user, Model model) {

        if (user != null) {
            AppUser currentUser = service.findByUsername(user.getUsername());
            System.out.println("Principal: " + user.getUsername());
            System.out.println("Found AppUser: " + currentUser);
            model.addAttribute("user", currentUser);
        }else{
            model.addAttribute("user", null);
        }

        List<Blog> allBlogs = blogService.findAll();


        model.addAttribute("blogs", allBlogs);

        return "blogs";
    }

    //sign up page
    @GetMapping("/showSignupPage")
    public String showSignup(Model model){
        model.addAttribute("User", new SignupDto());
        return "signup";
    }

    //login page
    @GetMapping("/showLogin")
    public String showLogin(){

        return "login";
    }


    //write blog
    @GetMapping("/writeBlog")
    public String writeBlog(Model model){

        model.addAttribute("blog", new BlogDto());

         return "create-blog";
    }
}
