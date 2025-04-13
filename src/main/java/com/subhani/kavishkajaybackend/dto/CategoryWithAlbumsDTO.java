package com.subhani.kavishkajaybackend.dto;

import java.util.List;

public class CategoryWithAlbumsDTO {

    private Long categoryId;
    private String categoryName;
    private List<AlbumDTO> albums;

    public CategoryWithAlbumsDTO() {
    }

    public CategoryWithAlbumsDTO(Long categoryId, String categoryName, List<AlbumDTO> albums) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.albums = albums;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<AlbumDTO> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumDTO> albums) {
        this.albums = albums;
    }
}
