package com.blog.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity httpSecurity) {

        httpSecurity.authorizeHttpRequests((request) ->
                        request.requestMatchers("/").permitAll()
                                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                                .anyRequest().authenticated()

                )
                .formLogin((login) ->
                        login.loginPage("/login")
                                .defaultSuccessUrl("/showBlogs")
                                .failureUrl("/login?error=cannotLogin")
                                .permitAll()
                )
                .logout((logout) ->
                        logout.logoutUrl("/logout")
                                .logoutSuccessUrl("/showBlogs")
                );

        return httpSecurity.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
