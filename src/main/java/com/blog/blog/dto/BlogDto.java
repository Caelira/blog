package com.blog.blog.dto;

import jakarta.validation.constraints.NotBlank;

public class BlogDto {


    @NotBlank(message = "Title cant be blank")
    private String title;

    @NotBlank(message = "Content cannot be blank")
    private String content;

    public BlogDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public BlogDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
