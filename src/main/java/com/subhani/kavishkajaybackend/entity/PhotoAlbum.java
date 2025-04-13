package com.subhani.kavishkajaybackend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class PhotoAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;

    private String name;

    private LocalDate publishedDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private PortfolioCategory category;

    public PhotoAlbum() {
    }

    public PhotoAlbum(Long albumId, String name, LocalDate publishedDate, PortfolioCategory category) {
        this.albumId = albumId;
        this.name = name;
        this.publishedDate = publishedDate;
        this.category = category;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public PortfolioCategory getCategory() {
        return category;
    }

    public void setCategory(PortfolioCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "PhotoAlbum{" +
                "albumId=" + albumId +
                ", name='" + name + '\'' +
                ", publishedDate=" + publishedDate +
                ", category=" + category +
                '}';
    }
}
