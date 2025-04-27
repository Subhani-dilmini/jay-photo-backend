package com.subhani.kavishkajaybackend.dto;

import java.time.LocalDateTime;

public class BlogDTO {
    private Long blogId;
    private String title;
    private String description;
    private LocalDateTime publishedDate;

    public BlogDTO() {
    }

    public BlogDTO(Long blogId, String title, String description, LocalDateTime publishedDate) {
        this.blogId = blogId;
        this.title = title;
        this.description = description;
        this.publishedDate = publishedDate;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "BlogDTO{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publishedDate=" + publishedDate +
                '}';
    }
}
