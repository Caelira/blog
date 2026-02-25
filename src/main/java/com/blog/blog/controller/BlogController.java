package com.blog.blog.controller;

import com.blog.blog.dto.BlogDto;
import com.blog.blog.model.AppUser;
import com.blog.blog.model.Blog;
import com.blog.blog.model.CustomUserDetails;
import com.blog.blog.service.BlogService;
import com.blog.blog.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;

@Controller
public class BlogController {

    private UserService userService;
    private BlogService blogService;

    public BlogController(UserService userService, BlogService blogService) {
        this.userService = userService;
        this.blogService = blogService;
    }

    @PostMapping("/saveBlog")
    public String writeBlog(@AuthenticationPrincipal CustomUserDetails user,
                            @Valid @ModelAttribute("blog")BlogDto blogDto,
                            BindingResult result){

        if(userService.findByUsername(user.getUsername()) == null){
            return "login";
        }



        if(result.hasErrors()){
            if(result.hasFieldErrors("title")){
                result.getFieldError("title").getDefaultMessage();
            }
            if(result.hasFieldErrors()){
                result.getFieldError("content").getDefaultMessage();
            }
            return "create-blog";
        }
        AppUser currentUser = userService.findByUsername(user.getUsername());


        //build the blog
        Blog blog = new Blog();

        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setWrittenBy(currentUser);
        blog.setDateWritten(LocalDate.now());
        blogService.saveBlog(blog);
        return "blogs";
    }


    @GetMapping("/showBlogContent")
    public String showBlogContent(@RequestParam("id")Long id,
                                  @AuthenticationPrincipal CustomUserDetails userDetails,
                                  Model model){

        Blog blog = blogService.findById(id);

        if(blog == null){
            model.addAttribute("error", "blog not found");
            return "blogs";
        }
        System.out.println( "found blog::::: " +  blog.getTitle());
        model.addAttribute("blog", blog);

        return "blog-content";
    }
}
