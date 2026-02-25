package com.blog.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkController {

    @GetMapping("/")
    public String showBlogs(){

        return "blogs";
    }

    @GetMapping("/login")
    public String showLogin(){

        return "login";
    }
}
