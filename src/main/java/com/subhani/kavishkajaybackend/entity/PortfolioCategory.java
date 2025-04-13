package com.subhani.kavishkajaybackend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PortfolioCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<PhotoAlbum> albums = new ArrayList<>();

    public PortfolioCategory() {
    }

    public PortfolioCategory(Long id, String categoryName, List<PhotoAlbum> albums) {
        this.id = id;
        this.categoryName = categoryName;
        this.albums = albums;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<PhotoAlbum> getAlbums() {
        return albums;
    }

    public void setAlbums(List<PhotoAlbum> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "PortfolioCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", albums=" + albums +
                '}';
    }
}
