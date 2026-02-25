package com.blog.blog.controller;

import com.blog.blog.dto.SignupDto;
import com.blog.blog.model.AppUser;
import com.blog.blog.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService service;
    private PasswordEncoder passwordEncoder;

    public UserController(UserService service, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("User")SignupDto user, BindingResult result){
        if (result.hasErrors()) {
            return "signup";
        }

        if (service.findByUsername(user.getUsername()) != null) {
            result.rejectValue("username", null, "This username is already taken... xori pu");
            return "signup";
        }

        AppUser appUser = new AppUser();
        appUser.setUsername(user.getUsername());
        appUser.setName(user.getName());
        appUser.setPassword(passwordEncoder.encode(user.getPassword()));
        appUser.setRole("USER");

        service.saveUser(appUser);
        return "redirect:/showLogin";
    }
}
