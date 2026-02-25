package com.blog.blog.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity(name = "blog_entry")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateWritten;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "written_by_user_id")
    private AppUser writtenBy;

    public Blog(Long id, LocalDate dateWritten, String title, String content, AppUser writtenBy) {
        this.id = id;
        this.dateWritten = dateWritten;
        this.title = title;
        this.content = content;
        this.writtenBy = writtenBy;
    }

    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateWritten() {
        return dateWritten;
    }

    public void setDateWritten(LocalDate dateWritten) {
        this.dateWritten = dateWritten;
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

    public AppUser getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(AppUser writtenBy) {
        this.writtenBy = writtenBy;
    }

}
